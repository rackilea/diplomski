Cluster cluster = Cluster.open("conf/remote-objects.yaml");

// use client to create the schema
Client client = cluster.connect();
String schema = "mgmt=graph.openManagement();";
schema += "mgmt.makeVertexLabel(\"person\").make();";
schema += "mgmt.makeVertexLabel(\"person\");";
schema + "mgmt.makePropertyKey(\"name\").dataType(String.class).make();"
schema += "mgmt.commit(); true";
CompletableFuture<List<Result>> results = client.submit(schema).all();

// use traversals only to interact with the graph
Graph graph = EmptyGraph.instance();
GraphTraversalSource g = graph.traversal().withRemote(DriverRemoteConnection.using(cluster));
Vertex v = g.addV("person").property("name", "pepe").next();
List<Vertex> vlist = g.V().toList();