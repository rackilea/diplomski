public class Request {

  public static class Version {
    public String versionname;
    public int number;

    protected Version() {} // for deserializer

    public Version(String versionname, int number) {
      this.versionname = versionname;
      this.number = number;
    }
  }

  public List<Version> versions = new ArrayList<>();
  public int id;
  public String name;
}

Request request = new Request();
request.versions.add(new Version("Test", 1));
request.id = 19;
request.name = "TEST";

String jsonString = new ObjectMapper().writeValueAsString(request);

Request deserialized = new ObjectMapper().readValue(jsonString, Request.class);