private static <T,S> TableColumn<T,S> createTableColumn(Class<S> type, Field field, String text) {
    TableColumn<T, S> col =  new TableColumn<T,S>(text);
    col.setCellValueFactory(cellData -> {
        try {
            boolean wasAccessible = field.isAccessible() ;
            field.setAccessible(true);
            @SuppressWarnings("unchecked")
            SimpleObjectProperty<S> property = new SimpleObjectProperty<S>((S)(field.get(cellData.getValue())));
            field.setAccessible(wasAccessible);
            return property;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    });
    return col ;
}