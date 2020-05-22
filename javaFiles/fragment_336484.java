class Tree private (val root: Node) { }
object Tree {
  def create(data: List[Data2D]) = {
    new Tree( buildNodesFrom(data) )
  }
}