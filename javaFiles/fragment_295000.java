scala> class A {
     |   @annotation.varargs def foo(x: Int*) { println(x) }
     | }
defined class A

scala> println(classOf[A].getMethods.toList)
List(public void $line1.$read$$iw$$iw$A.foo(scala.collection.Seq), public void $line1.$read$$iw$$iw$A.foo(int[]), ...)