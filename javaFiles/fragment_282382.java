public class Wrapper {
  public Response response;
} 
public class Response {
  public Map<String,Integer> features; // or maybe Map<String,Object>
  public List<HistoryItem> history;
}
public class HistoryItem {
  public MyDate date; // or just Map<String,String>
  // ... and so forth
}