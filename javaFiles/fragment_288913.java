public class Response {
  public long id;
  public Object rated;
}
// OR
public class Response {
  public long id;
  public JsonNode rated;
}
Response r = mapper.readValue(source, Response.class);