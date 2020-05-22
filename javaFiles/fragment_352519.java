public static Optional<DataHolder> getDataHolder(String processName, Record record) {
    Optional<DataHolder> dataHolder = Optional.empty();
    if (isValid(processName, record)) {
        dataHolder = Optional.of(buildDataHolder(processName, record));
        // ...
    }
    return dataHolder;
}