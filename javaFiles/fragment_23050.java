public class EdgeModel extends AbstractCollection<Edge> implements Observable {
    private List<Edge> edges = new ArrayList<Edge>();
    @Override public Iterator<Edge> iterator() { return edges.iterator(); }
    @Override public int size() { return edges.size(); }
    @Override public boolean add(Edge edge) {
        if (edges.add(edge)) {
            this.notifyObservers();
            return true;
        }
        return false;
    }

    // other stuff for Observable
}

public class EdgeView implements Observer {
    public void setModel(EdgeModel model) {
        model.addObserver(this);
    }
    public void update(Observable o, Object arg) {
        // model o has changed... update something visual I guess
    }
}