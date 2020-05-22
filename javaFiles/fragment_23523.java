public interface Graphable {
    void graph();
}

public class J48Tree extends AbstractTree implements Graphable {
    @Override
    public void graph() {
        // implementation
    }
}

public class RandomTree extends AbstractTree implements Graphable {
    @Override
    public void graph() {
        // implementation
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