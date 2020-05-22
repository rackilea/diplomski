String url = "whatever.your.url.is";
HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

connection .setRequestProperty("Content-Type", "application/json");
connection .setRequestMethod("POST");
JSONObject json =new JSONObject();
JSONObject skills =new JSONObject();
skills.put("__op", "AddUnique");
skills.put("objects", new JSONArray(Arrays.asList("flying", "kungfu"));
json.put("skills": skills);
OutputStreamWriter wr= new OutputStreamWriter(connection.getOutputStream());
wr.write(json.toString());