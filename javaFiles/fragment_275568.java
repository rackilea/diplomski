@tailrec
def tailRecCombineWith(permutatedLists: Iterator[List[List[Int]]], remainingLists: List[List[Int]]): Iterator[List[List[Int]]] = remainingLists match {
  case Nil => permutatedLists
  case head :: tail => tailRecCombineWith(for {
    a: List[List[Int]] <- permutatedLists
    b: List[Int] <- head.permutations
  } yield a :+ b, tail)
}

val result: Iterator[List[List[Int]]] = 
  tailRecCombineWith(lists.head.permutations.map(List(_)), lists.tail)