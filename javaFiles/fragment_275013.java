scala> Example.named
res0: java.util.HashMap[String,java.util.ArrayList[java.util.ArrayList[Double]]] = {matrix=[[1.0, 2.0], [3.0, 4.0]]}

scala> val sc = Example.asScala(Example.named)
sc: scala.collection.immutable.Map[String,Array[Array[Double]]] = Map(matrix -> Array([D@1ea817f, [D@dbd794))

scala> sc("matrix")(0)
res1: Array[Double] = Array(1.0, 2.0)

scala> sc("matrix")(1)
res2: Array[Double] = Array(3.0, 4.0)