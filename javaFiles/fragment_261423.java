import scala.collection.JavaConverters._

def getAllStudents() : Seq[Student] = {
  getSession().createQuery("from Student where isDelete =  'false' ")
    .list().asScala
 }