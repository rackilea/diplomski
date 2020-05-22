public class Data {
  private Map<String, String> guid;

  public Map<String, String> getGuid() {
    return guid;
  }

  public void setGuid(Map<String, String> guid) {
    this.guid = guid;
  }

  public static void main(String[] args) {
    String json =
        "{\"guid\":{" + "\"uri\":\"http://social.yahooapis.com/v1/me/guid\","
            + "\"value\":\"123456789\"}}";
    Data data = new Gson().fromJson(json, Data.class);
    System.out.println(data.getGuid()
        .get("uri"));
  }
}