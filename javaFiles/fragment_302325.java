public class MyObjectDataSerializerTest {

    @Test
    public void shouldCustomSerializeMyObjectData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(MyObjectData.class, new MyObjectDataSerializer());
        mapper.registerModule(module);

        MyObjectData myObjectData = new MyObjectData();
        myObjectData.setObjectId(25);
        myObjectData.setColumnValues(Arrays.asList(
                new MyObjectRow("Category One", 1),
                new MyObjectRow("Category Two", 2),
                new MyObjectRow("Category Three", 3)
        ));


        String serialized = mapper.writeValueAsString(myObjectData);

        assertThat(serialized, equalTo("{\"objectId\":25,\"columnName\":[\"myCategory\",\"myCategoryId\"],\"columnValues\":[[\"Category One\",1],[\"Category Two\",2],[\"Category Three\",3]]}\n"));
    }

}