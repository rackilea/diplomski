InputStream response = urlConnect.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(response));
StringBuilder sb = new StringBuilder();
String line;
while ((line = br.readLine()) != null) {
    sb.append(line+"\n");
}
br.close();

JSONObject object = new JSONObject(sb.toString()); //Converted to JSON Object from JSON string - Assuming response is a valid JSON object.