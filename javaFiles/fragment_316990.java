enum MyMetaDataKey implements HyptheticalMetaDataKeyInterface {

    TITLE(String.class),
    WIDTH(Integer.class);

    private final Class<?> type;

    private MyMetaDataKey(Class<?> t) { type = t; }
    public Class<?> getType() { return type; }
}