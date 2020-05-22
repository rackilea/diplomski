public class Bar {
  @JsonCreator
  public Bar (@JsonProperty("par1") int par1, @JsonProperty("par2") int par 2) {
    ...
  }
  public static void main( String[] args )  {
    String json = "{\"par1\":1,\"par2\":2}";
    Bar bar = (Bar)new ObjectMapper().readValue(json, Bar.class);
  }
}