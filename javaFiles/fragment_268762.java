scala> import scala.io.Source
import scala.io.Source

scala> val take = List(2, 3, 2, 1)
take: List[Int] = List(2, 3, 2, 1)

scala> val data = Source.fromFile("/tmp/testdataI.txt").getLines().map(_.split(",").map(_.trim.toInt).toList).toList
data: List[List[Int]] = List(List(1, 2), List(3), List(1), List(3, 2), List(1, 2), List(1, 2), List(5), List(6))

scala> def awesomeGrouped(ungrouped: List[List[Int]], take: List[Int]): List[List[List[Int]]] = take match {
     |         case Nil => Nil
     |         case t :: ts => ungrouped.take(t) :: awesomeGrouped(ungrouped.drop(t), ts)
     |     }
awesomeGrouped: (ungrouped: List[List[Int]], take: List[Int])List[List[List[Int]]]

scala> def fixTypes(grouped: List[List[List[Int]]]) = grouped.map(_.map(_.toArray).toArray)
fixTypes: (sorted: List[List[List[Int]]])List[Array[Array[Int]]]

scala> fixTypes(awesomeGrouped(data, take))
res0: List[Array[Array[Int]]] = List(Array(Array(1, 2), Array(3)), Array(Array(1), Array(3, 2), Array(1, 2)), Array(Array(1, 2), Array(5)), Array(Array(6)))