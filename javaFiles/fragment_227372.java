@Test
public void test(){

    StringTypeHandler nullableStringTypeHandler = new StringTypeHandler();
    nullableStringTypeHandler.setNullIfEmpty(true);
    nullableStringTypeHandler.setTrim(true);

    StreamFactory factory = StreamFactory.newInstance();
    factory.define(new StreamBuilder("pojo")
        .format("fixedlength")
        .addRecord(Pojo.class)
        .addTypeHandler(String.class, nullableStringTypeHandler)
    );


    Unmarshaller unmarshaller = factory.createUnmarshaller("pojo");

    Pojo pojo = (Pojo) unmarshaller.unmarshal("     ");
    assertNull(pojo.field);

}