HttpResponse response = httpclient.execute(httppost);
HttpEntity entity = response.getEntity();
InputStream is = entity.getContent();

try {
     BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 256);
 StringBuilder sb = new StringBuilder();
 String line = null;
 while ((line = reader.readLine()) != null)  sb.append(line); 
     result = sb.toString();
 is.close();
} catch (Exception e) {}

 JSONArray jArray = new JSONArray(result);
 for(int i = 0; i < jArray.length(); i++) {
JSONObject json_data = jArray.getJSONObject(i);
String url= json_data.getString("url");
    String expires= json_data.getString("expires");
 }