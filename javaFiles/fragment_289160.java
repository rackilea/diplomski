final class FilteredGridLayout extends VerticalLayout {

    private final PersonGrid personGrid;
    private final TextField nameFilter;

    public FilteredGridLayout() {
        nameFilter = new TextField();
        nameFilter.setPlaceholder("Name...");
        nameFilter.addValueChangeListener(this::onNameFilterTextChange);
        addComponent(nameFilter);

        personGrid = new PersonGrid();
        addComponentsAndExpand(personGrid);
    }

    private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
        ListDataProvider<Person> dataProvider = (ListDataProvider<Person>) personGrid.getDataProvider();
        dataProvider.setFilter(Person::getName, s -> caseInsensitiveContains(s, event.getValue()));
    }

    private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }

}