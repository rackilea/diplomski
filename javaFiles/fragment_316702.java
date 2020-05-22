@Test
public void shouldDoTheTrick() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    mapper.addMixIn(Object.class, ObjectMixin.class);

    Parent parent = new Parent("Hello", new Child1(-1), new MyMap() {{
        put("JustString", "JustValue");
        put("List_With_All_MyMaps", new ListWrapper.MyMapListWrapper(new ArrayList<MyMap>() {{
            add(new MyMap() {{
                put("Key", "Value");
                put("object", new Child1(2));
            }});
            add(new MyMap() {{
                put("Key", "Value");
            }});
        }}));
        put("List_With_All_Child1", new ListWrapper.Child1ListWrapper(new ArrayList<Child1>() {{
            add(new Child1(41));
            add(new Child1(42));
        }}));
    }});

    String valueAsString = mapper.writeValueAsString(parent);

    Parent deser = mapper.readValue(valueAsString, Parent.class);
    assertEquals(parent, deser);
}