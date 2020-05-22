scala> :edit res0
+Map("field" -> Left("value"),"mapField"-> Right(Map("internalField"->"someValue")))
res6: scala.collection.immutable.Map[String,Product with Serializable with scala.util.Either[String,scala.collection.immutable.Map[String,String]]] = Map(field -> Left(value), mapField -> Right(Map(internalField -> someValue)))

scala> .mapValues { case Left(s) => s.length case Right(m) => m.values.map(_.length).sum }
res7: scala.collection.immutable.Map[String,Int] = Map(field -> 5, mapField -> 9)