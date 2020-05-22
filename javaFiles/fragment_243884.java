public class UserLocation {
  public long id;
  public String text;
  public String createdat;
  public String userlocation;
  public String name;
  public String username;
  public String lat;
  public String lon;
  @Override
  public String toString() {
    return Long.toString(id)+text+createdat+userlocation+name+username+lat+lon;
  }
}