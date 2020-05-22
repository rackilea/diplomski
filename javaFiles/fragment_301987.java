columns.add(new AbstractColumn<Classification, String>(Model.of("")) {
    private static final long serialVersionUID = 1L;

    @Override
    public void populateItem(Item<ICellPopulator<Classification>> cellItem, String componentId, final IModel<Classification> rowModel) {
        // your model
        cellItem.add(new MyCellPanel(componentId, rowModel, tree));
    }
});