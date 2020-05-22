class Edge<A, B> {
    class MyEdgeHolder<E extends Edge<A, B>> extends EdgeHolder<E, A, B> {}
}
class MyEdge extends Edge<MyNodeType, MyOtherNodeType> {
    class MyEdgeHolder extends Edge<MyNodeType, MyOtherNodeType>.MyEdgeHolder<MyEdge> {}
}