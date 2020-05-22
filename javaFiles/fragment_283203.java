RowHeaderLayer rowHeaderLayer =
    new RowHeaderLayer(rowHeaderDataLayer, bodyLayer, bodyLayer.getSelectionLayer());

rowHeaderLayer.setConfigLabelAccumulator(new IConfigLabelAccumulator() {

    @Override
    public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition) {
        Person person = bodyLayer.getBodyDataProvider().getRowObject(rowPosition);
        if (person.isMarried()) {
            configLabels.addLabel("MARRIED");
        }
    }
});