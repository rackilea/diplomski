col.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<T>() {

    @Override
    public T fromString(String arg0) {
        return null; // <== need to map back..
    }

    @Override
    public String toString(T object) {
        return object.toString();
    }

}));