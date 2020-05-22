class ContentValuesAdapter {

    private ContentValues values;

    public ContentValuesAdapter(ContentValues values) {
        this.values = values;
    }

    public void put(String columnName, Object value) {
        if(value instanceof String) {
            values.put(columnName, (String) value);
        } else if ( ... ) {
            ...
        }
    }

    public ContentValues getContentValues() {
        return this.values;
    }

    /* Delegate all other methods to the ContentValue instance. */
}