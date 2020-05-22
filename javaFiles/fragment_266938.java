JSONObject obj = new JSONObject("{ \"result\" : \"xml content in tag format\" }");
public static void main(String[] args) throws JSONException
{
    JSONObject jsonObj = new JSONObject(obj);
    JSONObject result= jsonObj.getJSONObject("result");
    System.out.println("result----->"+result)
}