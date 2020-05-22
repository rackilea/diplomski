Region region = null;
Set<Node> nodes = table.lookupAll(".clipped-container");
for (Node node : nodes) {
    if (node instanceof Region) {
        region = (Region) node;
    }
}
for (TableColumn<Locale, ?> column : table.getColumns()) {
    column.setPrefWidth(region.getWidth() / table.getColumns().size());
}