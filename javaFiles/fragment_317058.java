GridFilters<MyRow> filters = new GridFilters<MyRow>();

filters.initPlugin(grid);

StringFilter<MyRow> filter = new StringFilter<MyRow>(nameValueProvider) {
  @Override
  protected boolean validateModel(MyRow model) {
    Window.alert("Hello");
    return super.validateModel(model);
  }
};

filters.addFilter(filter);
filters.setLocal(true);