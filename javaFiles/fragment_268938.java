private static final Map<String, Function<ResultSet, Object>> mappings = new HashMap<String, Function<ResultSet, Object>>() {{
    put("field1", ResultSet::getField1);
    put("field2", ResultSet::getField2);
    put("field3", ResultSet::getField3);
    put("field4", ResultSet::getField4);
}};