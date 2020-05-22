public interface Graphable {
    void graph();
}

public class J48TreeWrapper implements Graphable {
    private final J48Tree j48Tree;

    public J48TreeWrapper(J48Tree j48Tree) {
        this.j48Tree = j48Tree;
    }

    @Override
    public void graph() {
        this.j48Tree.graph();
    }
}

public class RandomTreeWrapper implements Graphable {
    private final RandomTree randomTree;

    public RandomTreeWrapper(RandomTree andomTree) {
        this.randomTree = randomTree;
    }

    @Override
    public void graph() {
        this.randomTree.graph();
    }
}

public class Visualization {
    private Graphable graphable;

    public void setGraphable(Graphable graphable) {
        this.graphable = graphable;
    }

    public void graph() {
        this.graphable.graph();
    }
}