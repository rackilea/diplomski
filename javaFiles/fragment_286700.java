package net.ahm.graph;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;
import org.neo4j.graphdb.schema.IndexDefinition;
import org.neo4j.graphdb.schema.Schema;
import org.neo4j.kernel.impl.util.FileUtils;
import org.neo4j.kernel.impl.util.StringLogger;

public class DeleteLab {
    private static final int CHILDREN = 10000;
    private static final Logger LOG = Logger.getLogger(DeleteLab.class);

    public static void main(String[] args) throws Exception {
        FileUtils.deleteRecursively(new File("graphdb"));
        final GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabaseBuilder("graphdb")
                .setConfig(GraphDatabaseSettings.use_memory_mapped_buffers, "true").setConfig(GraphDatabaseSettings.cache_type, "strong")
                .newGraphDatabase();
        registerShutdownHook(graphDb);
        LOG.info(">>>> STARTED GRAPHDB");
        createIndex("Parent", "name", graphDb);
        createIndex("Child", "name", graphDb);
        final Node parent;

        try (Transaction tx = graphDb.beginTx()) {
            parent = graphDb.createNode(DynamicLabel.label("Parent"));
            parent.setProperty("name", "parent");
            tx.success();
        }

        try (Transaction tx = graphDb.beginTx()) {
            for (int i = 0; i < CHILDREN; i++) {
                Node child = graphDb.createNode(DynamicLabel.label("Child"));
                child.setProperty("name", "child" + i);
                child.setProperty("count", i);
                parent.createRelationshipTo(child, RelationshipTypes.PARENT_CHILD);
            }
            tx.success();
        }
        LOG.info(">>>> CREATED NODES");
        final ExecutionEngine engine = new ExecutionEngine(graphDb, StringLogger.SYSTEM);
        ExecutorService es = Executors.newFixedThreadPool(50);
        final CountDownLatch cdl = new CountDownLatch(CHILDREN);

        for (int i = 0; i < CHILDREN; i++) {
            final int count = i;
            es.execute(new Runnable() {
                @Override
                public void run() {
                    String cName = null;
                    boolean success = false;
                    try (Transaction tx = graphDb.beginTx()) {
                        while (!success) {
                            try {
                                Map<String, Object> params = new HashMap<String, Object>();
                                params.put("cCount", count);
                                ExecutionResult result = engine.execute(
                                        "match (n:Parent)-[:PARENT_CHILD]->(m:Child) where m.count={cCount} return m.name", params);
                                for (Map<String, Object> row : result) {
                                    cName = (String) row.get("m.name");
                                    break;
                                }
                                success = true;
                            } catch (org.neo4j.graphdb.NotFoundException e) {
                                LOG.info(">>>> RETRY QUERY ON NotFoundException: " + count);
                                try {
                                    Thread.sleep((long) Math.random() * 100);
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }
                    }

                    try (Transaction tx = graphDb.beginTx()) {
                        if (cName != null) {
                            tx.acquireWriteLock(parent);
                            Node child = findNode("Child", "name", cName, graphDb);
                            Relationship r = child.getSingleRelationship(RelationshipTypes.PARENT_CHILD, Direction.INCOMING);
                            r.delete();
                            child.delete();
                            LOG.info(">>>> DELETING NODES: " + cName);
                        }
                        tx.success();
                    } finally {
                        cdl.countDown();
                    }
                }
            });
        }
        cdl.await();
        LOG.info(">>>> DELETED NODES");
        es.shutdown();
    }

    private static void createIndex(String label, String propertyName, GraphDatabaseService graphDb) {
        IndexDefinition indexDefinition;
        try (Transaction tx = graphDb.beginTx()) {
            Schema schema = graphDb.schema();
            indexDefinition = schema.indexFor(DynamicLabel.label(label)).on(propertyName).create();
            tx.success();
        }
        try (Transaction tx = graphDb.beginTx()) {
            Schema schema = graphDb.schema();
            schema.awaitIndexOnline(indexDefinition, 10, TimeUnit.SECONDS);
            tx.success();
        }
    }

    private static void registerShutdownHook(final GraphDatabaseService graphDb) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                LOG.info("### GRAPHDB SHUTDOWNHOOK INVOKED !!!");
                graphDb.shutdown();
            }
        });
    }

    private enum RelationshipTypes implements RelationshipType {
        PARENT_CHILD
    }

    public static Node findNode(String labelName, String propertyName, Object propertyValue, GraphDatabaseService graphDb) {
        if (propertyValue != null) {
            Label label = DynamicLabel.label(labelName);
            ResourceIterable<Node> ri = graphDb.findNodesByLabelAndProperty(label, propertyName, propertyValue);
            if (ri != null) {
                try {
                    ResourceIterator<Node> iter = ri.iterator();
                    try {
                        if (iter != null && iter.hasNext()) {
                            return iter.next();
                        }
                    } finally {
                        iter.close();
                    }
                } catch (Exception e) {
                    LOG.error("ERROR WHILE FINDING ID: " + propertyValue + " , LABEL: " + labelName + " , PROPERTY: " + propertyName, e);
                }
            }
        }
        return null;
    }
}