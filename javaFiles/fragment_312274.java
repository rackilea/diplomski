import scala.jdk.javaapi.CollectionConverters

def getConfigId: Long = {
  val values = objectRepo.findByUser(User(session.id))
  val index = values.asScala.map(_.endDate).zipWithIndex.max._2
  values.get(index).configId
}