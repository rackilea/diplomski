class Graph<T extends Node> {
    public void addNode(T node) { ... }
}

class DFA extends Graph<State> {
    @Override
    public void addNode(State node) { ... }
}