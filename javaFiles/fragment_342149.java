@Test
public void canSerializeParametricInterface() throws IOException {
    final ObjectMapper mapper = new ObjectMapper().enableDefaultTyping();
    final JavaType baseInterface = TypeFactory.defaultInstance().constructParametricType(Result.class, String.class);
    final JavaType subType = TypeFactory.defaultInstance().constructSpecializedType(baseInterface, Success.class);
    final ObjectWriter writer = mapper.writerWithType(subType);
    final String json = writer.writeValueAsString(Success.create("test"));
    Assert.assertEquals("{\"value\":\"test\"}", json);
}

@Test
public void canDeserializeParametricInterface() throws IOException {
    final ObjectMapper mapper = new ObjectMapper().enableDefaultTyping();
    final JavaType baseInterface = TypeFactory.defaultInstance().constructParametricType(Result.class, String.class);
    final JavaType subType = TypeFactory.defaultInstance().constructSpecializedType(baseInterface, Success.class);
    final ObjectReader reader = mapper.reader(subType);
    final Success<String> success = reader.readValue("{\"value\":\"test\"}");
    Assert.assertEquals("test", success.getValue());
}

public static interface Result<T> {
}

public static class Success<T> implements Result<T> {

    private T value;

    public static <T> Success<T> create(T value) {
        final Success<T> success = new Success<T>();
        success.value = value;
        return success;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}