private static Map<String, Object> avroGenericRecordToMap(GenericRecord record)
{
    Map<String, Object> map = new HashMap<>();
    record.getSchema().getFields().forEach(field -> 
        map.put(String.valueOf(field.name()), record.get(field.name())));

    // Strings are maped to Utf8 class, so they need to be casted (all the keys of records and those values which are typed as string)
    if(map.get("value").getClass() ==  org.apache.avro.util.Utf8.class)
        map.put("value", String.valueOf(map.get("value")));

    return map;
}