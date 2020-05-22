final List<String> myGridData = new ArrayList<>();
myGridData.add("value 1");
myGridData.add("value 2");

IterableDataProvider<String> iterableDataProvider = new IterableDataProvider<String>(10) {
    @Override
    protected Iterator<String> iterator() {
        return myGridData.iterator();
    }

    @Override
    public IModel<String> model(String s) {
        return Model.of(s);
    }

    @Override
    public void detach() {
    }
};

IterableGridView<String> myGrid = new IterableGridView<String>("myGrid", iterableDataProvider) {
    @Override
    protected void populateEmptyItem(Item<String> item) {
        item.add(new Label("myValue"));
    }

    @Override
    protected void populateItem(Item<String> item) {
        item.add(new Label("myValue", item.getModelObject()));
    }
};

add(myGrid);

myGrid.setItemsPerPage(10);

// you have to use custom pager and not AjaxPagingNavigator
IterablePagingNavigator pager = new IterablePagingNavigator("rowNamesListPager", rowNamesList);
resultTable.add(pager);