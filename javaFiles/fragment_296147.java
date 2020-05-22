@tailrec
def extractText(nodes: Seq[xml.Node], result: List[String] = Nil): Seq[String] = nodes match { 
  case Seq() => result.reverse
  case Seq(xml.Text(t), tail@_*) => extractText(tail, t :: result)
  case Seq(head, tail@_*) => extractText(head.child ++ tail, result)
}