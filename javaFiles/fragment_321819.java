private List<Node> findWrapped(FlowPane flow) {
    List<Node> wrapped = new ArrayList<>();
    if (flow.getChildren().size() == 0) {
        return wrapped ;
    }
    double y = flow.getChildren().get(0).getBoundsInParent().getMaxY();
    for (Node child : flow.getChildren()) {
        if (child.getBoundsInParent().getMinY() >= y) {
            wrapped.add(child);
        }
    }
    return wrapped ;
}