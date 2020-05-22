static <S, T> Callback<TableColumn.CellDataFeatures<S, T>, ObservableValue<T>> createArrayValueFactory(Function<S, T[]> arrayExtractor, final int index) {
    if (index < 0) {
        return cd -> null;
    }
    return cd -> {
        T[] array = arrayExtractor.apply(cd.getValue());
        return array == null || array.length <= index ? null : new SimpleObjectProperty<>(array[index]);
    };
}