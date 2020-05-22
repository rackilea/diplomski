AsTableColumn anno = field.getAnnotation(AsTableColumn.class);
TableColumn<T, Object> col = new TableColumn<>(anno.text());
col.setCellValueFactory(cellData -> {
    try {
        boolean wasAccessible = field.isAccessible() ;
        field.setAccessible(true);
        SimpleObjectProperty<Object> property = new SimpleObjectProperty<>(field.get(cellData.getValue()));
        field.setAccessible(wasAccessible);
        return property;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

});