scala> val list = List(1, 2, 3)
list: List[Int] = List(1, 2, 3)

scala> for (elem <- list) {
     |   println(elem)
     | }
1
2
3

scala> elem
<console>:12: error: not found: value elem
       elem
       ^