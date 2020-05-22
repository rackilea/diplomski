import scala.collection.JavaConverters._

type Foo = Int // Just to make it compile
val scalaMap = Map(1.0 -> Vector(1, 2)) // As an example

val javaMap = scalaMap.map { 
  case (d, v) => d -> v.toIterable.asJava
}.asJava