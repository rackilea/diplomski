interface Edge<S extends Node, T extends Node> {
}

// The bounds on the type parameters of Edge effectively apply here, too:
public class EdgeSet <E extends Edge<?, ?>> {
    // ...
}

public class SomeObject {

    protected EdgeSet<ConcreteEdge<ConcreteNodeA, ConcreteNodeB>> someEdgeSet;

    ...

    public EdgeSet<? extends ConcreteEdge<? extends ConcreteNodeA, ? extends ConcreteNodeB>> getEdges() { 
        return someEdgeSet;
    }
}