for(Map.Entry<String, Object> entry : valueSet){
        String columnName = entry.getKey();
        int idx = valueCursor.getColumnIndex(columnName);
        assertFalse(idx == -1);
        String expectedValue = entry.getValue().toString();
        if((Cursor.FIELD_TYPE_FLOAT == valueCursor.getType(idx))
                && valueCursor.getDouble(idx) % 1 == 0){
            assertEquals(expectedValue, valueCursor.getString(idx) + ".0");
        } else {
            assertEquals(expectedValue, valueCursor.getString(idx));
        }
    }