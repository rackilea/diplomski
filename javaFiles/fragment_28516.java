public class Evil {
  @JsonProperty("evil.property")
  public int evil;
}

@RunWith(MockitoJUnitRunner.class)
public class MapperTest {
  @Test
  public void mapperTest() throws JsonParseException, JsonMappingException, IOException {
    final ObjectMapper mapper = new ObjectMapper();
    final String test = "{ \"evil.property\" : 2 }";
    final Evil evil = mapper.readValue(test, Evil.class);
    assertThat(evil.evil, is(2));
  }
}