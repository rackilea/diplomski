scala> import scala.collection.JavaConversions._
import scala.collection.JavaConversions._

scala> val myMap = Map(1->"Hi",2->"Bye")
myMap: scala.collection.immutable.Map[Int,java.lang.String] = Map((1,Hi), (2,Bye))

scala> val jmap = new java.util.HashMap[Int,String](myMap)  // Need explicit types
jmap: java.util.HashMap[Int,String] = {1=Hi, 2=Bye}