public class VolleyStringRequest {
    String url;
    String body;
    String value;
    public VolleyStringRequest(String url, String body, RequestHandlerInterface rh){
        this.url = url;
        this.body = body;
        this.rh = rh;
        value= "";
    }
  //...
}