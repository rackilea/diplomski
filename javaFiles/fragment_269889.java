for(Map.Entry<String, Object> entry : valueSet){
    String columnName = entry.getKey();
    int idx = valueCursor.getColumnIndex(columnName);
    assertFalse(idx == -1);
    switch(valueCursor.getType(idx)) {
        case Cursor.FIELD_TYPE_FLOAT:
            assertEquals(entry.getValue(), valueCursor.getDouble(idx));
            break;
        case Cursor.FIELD_TYPE_INTEGER:
            //assertEquals(entry.getValue(), valueCursor.getInt(idx)); // didn't work
            //assertTrue((new Integer((int)entry.getValue())).equals(valueCursor.getInt(idx)));
            assertEquals(Integer.parseInt(entry.getValue().toString()), valueCursor.getInt(idx));
        case Cursor.FIELD_TYPE_STRING:
            assertEquals(entry.getValue(), valueCursor.getString(idx));
            break;
        default:
            assertEquals(entry.getValue().toString(), valueCursor.getString(idx));
    }
}