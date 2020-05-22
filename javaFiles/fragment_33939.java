columns.put(new AbstractColumn<TestResult>(new Model<String>("test column")) {
    @Override
    public void populateItem(Item<ICellPopulator<TestResult>> cellItem, String componentId, IModel<TestResult> rowModel) {
        cellItem.add(new MyComponent(componentId));
    }
});