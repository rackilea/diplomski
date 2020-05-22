import scala.collection.JavaConverters._

import de.lmu.ifi.dbs.elki.algorithm.clustering.kmeans.KMeansElkan
import de.lmu.ifi.dbs.elki.algorithm.clustering.kmeans.initialization.RandomUniformGeneratedInitialMeans
import de.lmu.ifi.dbs.elki.data.model.KMeansModel
import de.lmu.ifi.dbs.elki.data.{Clustering, NumberVector}
import de.lmu.ifi.dbs.elki.database.{Database, StaticArrayDatabase}
import de.lmu.ifi.dbs.elki.datasource.ArrayAdapterDatabaseConnection
import de.lmu.ifi.dbs.elki.distance.distancefunction.minkowski.SquaredEuclideanDistanceFunction
import de.lmu.ifi.dbs.elki.utilities.random.RandomFactory


def createDatabase(coords: Seq[(Double, Double)]): Database = {
  // Allocate 2-d array (matrix).
  val data = Array.ofDim[Double](coords.length, 2)
  // Fill the matrix
  coords.zipWithIndex.foreach {
    case ((x, y), idx) =>
      data.update(idx, Array(x, y))
  }
  // Create a database
  val db = new StaticArrayDatabase(new ArrayAdapterDatabaseConnection(data), null)
  // Load the data into the database
  db.initialize()
  db
}

val nClusters = numberOfClustersForDemand // Set your number of clusters
val nIters = 1000
// Convert my own type to the seq of (Double, Double)
val coords = activities.map(act => (act.getCoord.getX, act.getCoord.getY))
val db: Database = createDatabase(coords)
// Create an instance of KMeansElkan clustering Algorithm
val kmeans: KMeansElkan[NumberVector] = new KMeansElkan[NumberVector](SquaredEuclideanDistanceFunction.STATIC, nClusters, nIters,
  new RandomUniformGeneratedInitialMeans(RandomFactory.DEFAULT),true)
// Run the algorithm
val result: Clustering[KMeansModel] = kmeans.run(db)
// Show the results
val clustersInfo: Array[ClusterInfo] = result.getAllClusters.asScala.zipWithIndex.map { case (cluster, idx) =>
  println(s"# $idx: ${cluster.getNameAutomatic}")
  println(s"Size: ${cluster.size()}")
  println(s"Model: ${cluster.getModel}")
  println(s"Center: ${cluster.getModel.getMean.toVector}")
  println(s"getPrototype: ${cluster.getModel.getPrototype.toString}")
  ClusterInfo(cluster.size, new Coord(cluster.getModel.getMean))
}.toArray