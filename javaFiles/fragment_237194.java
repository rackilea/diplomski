public class Response {
  public Meta meta;
}

public class Meta {
  public int total_rows;
  public String uri; // or could be URL or URI
  public int limit;
  public String limit_type; // or an Enum of { user, ... }
  public int requests;
  public int reset;
  public Data recorded;
}