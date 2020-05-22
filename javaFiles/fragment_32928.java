public enum SearchDataTypes {
    ...
    FIELD_DATATYPE_DATE(Date.class,"_dt");

    private static final Map<String,SearchDataTypes> affixMap = new HashMap<String,SearchDataType>();
    private static final Map<Class<?>, SearchDataTypes> classMap = new HashMap<Class<?>, SearchDataTypes>()
    static {
        for (SearchDataType value : values()) {
            map.put(value.affix, value);
            map.put(value.clazz, value);
        }
    }

    SearchDataTypes(final Class<?> clazz, final String affix) {
        this.affix = affix;
    ...
}