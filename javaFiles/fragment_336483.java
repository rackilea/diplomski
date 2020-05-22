class Tree private () {
  private var root: Node = null
}
object Tree { 
  def create(data: List[Data2D]) = {
    val tree = new Tree()
    buildTree(tree,data)
    tree
  }
}