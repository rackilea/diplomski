// the worker
public static class SceneGraphWorker extends Task<NodeState> {

    private List<Node> nodes;
    private int current;

    public SceneGraphWorker(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    protected NodeState call() throws Exception {
        while (current >= 0) {
            NodeState state = new NodeState(current);
            CountDownLatch latch = new CountDownLatch(1);
            Platform.runLater(() -> {
                Node node = nodes.get(current);
                Bounds bounds = node.localToScene(node.getBoundsInLocal());
                state.setState(bounds.getMinX(), bounds.getMinY());
                state.setID(node.getId());
                current = current == nodes.size() - 1 ? -1 : current + 1;
                latch.countDown(); 
            });
            latch.await();
            state.process();
            updateValue(state);
        }
        return null;
    }

}

// the handler: listens to value
public void handleWithWorker(MouseEvent ev, List<Node> nodesInGraph) {
    Task worker = new SceneGraphWorker(nodesInGraph);
    worker.valueProperty().addListener((src, ov, nv) -> {
        progress.setText(nv != null ? nv.toString() : "empty");
    });
    new Thread(worker).start();
}

// the state object
public static class NodeState {
    double x, y;
    int index;
    private String name;
    public NodeState(int index) {
        this.index = index;
    }
    public void setState(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void setID(String name) {
        this.name = name;
    }
    public void process() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Override
    public String toString() {
        return "[" + name + " x: " + x + " y: " + y + "]";
    }
}