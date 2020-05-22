class GraphViewFactory {
  fun get(data: Graph): GraphView {
     return when {
         is Graph1 -> TODO()
         is Graph2 -> TODO()
         else -> IllegalArgumentException()
     }
  }
}