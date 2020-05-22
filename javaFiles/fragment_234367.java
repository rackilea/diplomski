import org.neo4j.tooling.GlobalGraphOperations
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import org.neo4j.graphdb.RelationshipType

object tester extends App{

  val DB_PATH = "data/neo4j"
  object KNOWS extends RelationshipType {
    override def name(): String = "KNOWS"
  }
  val graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH)
  println(graphDb)

  val tx1 = graphDb.beginTx() // Database operations go here
  try {
    println("Will list all nodes")
    println("1 - Begin")
    println("GlobalGraphOperations.at(graphDb).getAllNodes.iterator")
    val nodes = GlobalGraphOperations.at(graphDb).getAllNodes.iterator
    while (nodes.hasNext()) {
      println(nodes.next())
    }
    nodes.close()
    val relT = GlobalGraphOperations.at(graphDb).getAllRelationships.iterator
    while (relT.hasNext()) {
      println(relT.next())
    }
    println("1 - Success - Begin")
    tx1.success()
  }
  finally {
    tx1.close()
  }

  val tx2 = graphDb.beginTx() // Database operations go here
  try {
    val firstNode = graphDb.createNode
    val secondNode = graphDb.createNode
    val relationship = firstNode.createRelationshipTo(secondNode, KNOWS)

    println(firstNode)
    println(secondNode)
    println(relationship)
    println(relationship.getType.name)
    tx2.success()
    println("2 - Success")
  }
  finally {
    tx2.close()
  }

  println("2 - End")

  val tx3 = graphDb.beginTx() // Database operations go here
  try {
    println(GlobalGraphOperations.at(graphDb).getAllNodes.iterator)
    val nodes = GlobalGraphOperations.at(graphDb).getAllNodes.iterator
    while (nodes.hasNext()) {
      println(nodes.next())
    }
    nodes.close()
    val relT = GlobalGraphOperations.at(graphDb).getAllRelationships.iterator
    while (relT.hasNext()) {
      println(relT.next())
    }
    println("3 - Success - End")
    tx3.success()
  }
  finally {
    tx3.close()
  }
  graphDb.shutdown()
}