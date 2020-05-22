scala> Map("field" -> "value","mapField"-> Map("internalField"->"someValue"))
res0: scala.collection.immutable.Map[String,Object] = Map(field -> value, mapField -> Map(internalField -> someValue))

scala> import collection.JavaConverters._
import collection.JavaConverters._

scala> res0.mapValues { case m: Map[_,_] => m.asJava case x => x }
res2: scala.collection.immutable.Map[String,Object] = Map(field -> value, mapField -> {internalField=someValue})

scala> res0.asJava
res3: java.util.Map[String,Object] = {field=value, mapField=Map(internalField -> someValue)}

scala> .asScala
res4: scala.collection.mutable.Map[String,Object] = Map(field -> value, mapField -> Map(internalField -> someValue))

scala> .foreach { case (k, v: collection.Map[_,_]) => println(v.toList) case _ =>  }
List((internalField,someValue))