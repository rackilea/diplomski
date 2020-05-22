public class CountRequest extends StringRequest {

private static final String LOGIN_REQUEST_URL = "http://mypage.com/login_user.php?login=a&password=b";
private Map<String, String> params;

public CountRequest(Response.Listener<String> listener){
    super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
    params = new HashMap<>();
}

@Override
public Map<String, String> getParams() {
    return params;
}}