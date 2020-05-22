scala> val is = (1 to 10).to[collection.mutable.LinkedList].asJava
warning: there were 2 deprecation warning(s); re-run with -deprecation for details
is: java.util.List[Int] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

scala> is sort (new java.util.Comparator[Int] { def compare(a: Int, b: Int) = b - a })

scala> is
res13: java.util.List[Int] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]