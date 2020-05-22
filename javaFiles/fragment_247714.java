public class TestClass {
    private String propertyA;

    // constructor/getters/setters
}

public class TestClassListHolder {

    @JsonProperty("ListOfTestClasses")
    private List<TestClass> data;

    // constructor/getters/setters
}

public class TestHarness {

    protected List<TestClass> getTestList() {
        return Arrays.asList(new TestClass("propertyAValue"), new TestClass(
                "someOtherPropertyValue"));
    }

    @Test
    public void testSerializeTestClassListDirectly() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        System.out.println(mapper.writeValueAsString(getTestList()));
    }

    @Test
    public void testSerializeTestClassListViaMap() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final Map<String, List<TestClass>> dataMap = new HashMap<String, List<TestClass>>(
                4);
        dataMap.put("ListOfTestClasses", getTestList());
        System.out.println(mapper.writeValueAsString(dataMap));
    }

    @Test
    public void testSerializeTestClassListViaHolder() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final TestClassListHolder holder = new TestClassListHolder();
        holder.setData(getTestList());
        System.out.println(mapper.writeValueAsString(holder));
    }

    @Test
    public void testSerializeTestClassListViaWriter() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final ObjectWriter writer = mapper.writer().withRootName(
                "ListOfTestClasses");
        System.out.println(writer.writeValueAsString(getTestList()));
    }
}