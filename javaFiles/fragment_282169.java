xAxis.getChildrenUnmodifiable().addListener((ListChangeListener<Node>) p -> {
    if (p.next()) {
        p.getAddedSubList().forEach(node -> {
            if (node != null && node instanceof Text) {
                final Text textNode = (Text) node;
                final Optional<XYChart.Data<String, Number>> data = bc.getData().get(0).getData().stream().filter(item -> item.getXValue().equalsIgnoreCase(textNode.getText())).findFirst();
                data.ifPresent(d -> {
                    Tooltip.install(textNode, new Tooltip(d.getXValue() + ":\n" + d.getYValue()));
                });
            }
        });
    }
});