import org.apache.spark.sql.types._
def findFields(path: String, dt: DataType): Unit = dt match {
  case s: StructType => 
    s.fields.foreach(f => findFields(path + "." + f.name, f.dataType))
  case other => 
    println(s"$path: $other")
}