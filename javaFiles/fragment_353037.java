public class JacksonMixin {
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    abstract class MixinAbc{}

    // Library class which I can't modify
    class Abc {
      private String firstName;

     }

    @Test
    public void testMixin() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(Abc.class, MixinAbc.class);
        Abc value = new Abc();
        value.firstName="bill";
        String writeValueAsString = objectMapper.writeValueAsString(value);
        Assert.assertEquals("{\"first_name\":\"bill\"}", writeValueAsString);

    }

}