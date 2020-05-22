public class JacksonTest {

    @Retention(RetentionPolicy.RUNTIME)
    @JacksonAnnotationsInside
    @JsonProperty("_id")
    @JsonSerialize(using=IdSerializer.class, include=Inclusion.NON_NULL)
    @JsonDeserialize(using=IdDeserializer.class)
    public @interface Id {
    }

    public static class Answer {
        @Id
        String id;
        String name;

        public Answer() {}
    }

    @Test
    public void testInside() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        VisibilityChecker<?> checker = mapper.getSerializationConfig().getDefaultVisibilityChecker();
        mapper.setVisibilityChecker(checker.withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        String string = "{ 'name' : 'John' , '_id' : { 'sub' : '47cc'}}".replace('\'', '"');
        Answer answer = mapper.reader(Answer.class).readValue(string);
        Assertions.assertThat(answer.id).isEqualTo("47cc");
    }
}