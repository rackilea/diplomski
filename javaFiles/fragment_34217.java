@Test
public void test() {
    Map<String, IMsgField> stubbedMap = new HashMap<String, IMsgField>();
    stubbedMap.put("id_object", new CMsgField("id_object", "100"));
    FieldsWrapper fieldsWrapper = mock(FieldsWrapper.class);
    stub(fieldsWrapper.getFields()).toReturn(stubbedMap);
}