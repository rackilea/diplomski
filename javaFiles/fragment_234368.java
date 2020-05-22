import org.neo4j.tooling.GlobalGraphOperations
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import org.neo4j.graphdb.RelationshipType
import org.neo4j.graphdb.Transaction
import scala.collection.JavaConverters._

object tester extends App{
  val DB_PATH = "data/neo4j"
  object KNOWS extends RelationshipType {
    override def name(): String = "KNOWS"
  }

  def withTransaction (doWithTransaction: Transaction => Unit) { 
    val tempTx = graphDb.beginTx() 

    try {
      doWithTransaction(tempTx)
    }
    finally {
      tempTx.close()
    }
  }

  val graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH)
  println(graphDb)

  withTransaction { tx => 
    println("1 - Begin")
    val nodes = GlobalGraphOperations.at(graphDb).getAllNodes 
    for (node <- nodes.asScala)
      println(node)

    val relTs = GlobalGraphOperations.at(graphDb).getAllRelationships
    for (irelT <- relTs.asScala) 
      println(irelT)

    println("1 - Success - Begin")
    tx.success()
  }


  withTransaction { tx => 
    val firstNode = graphDb.createNode
    val secondNode = graphDb.createNode
    val relationship = firstNode.createRelationshipTo(secondNode, KNOWS)

    println(firstNode)
    println(secondNode)
    println(relationship)
    println(relationship.getType.name)
    tx.success()
    println("2 - Success")
  }

  println("2 - End")

  withTransaction { tx => 
    println(GlobalGraphOperations.at(graphDb).getAllNodes.iterator)

    val nodes = GlobalGraphOperations.at(graphDb).getAllNodes 
    for (node <- nodes.asScala)
      println(node)

    val relTs = GlobalGraphOperations.at(graphDb).getAllRelationships
    for (irelT <- relTs.asScala) 
      println(irelT)

    println("3 - Success - End")
    tx.success()
  }

  graphDb.shutdown()
}