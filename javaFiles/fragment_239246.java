import org.apache.http.impl.DefaultHttpResponseFactory;
import org.json.JSONObject;


HttpResponseFactory factory = new DefaultHttpResponseFactory();
org.apache.http.HttpResponse response = factory.newHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, null), null);
JSONObject json = new JSONObject();
json.put("result", "10");
response.setEntity(new StringEntity(json.toString()));
com.mashape.unirest.http.HttpResponse<JsonNode> httpResponse = new HttpResponse<JsonNode>(response, JsonNode.class);