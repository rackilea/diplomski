String jsonString = IOUtils.toString(conn.getInputStream()); // where 'conn' is an HttpURLConnection
IOUtils.closeQuietly(connection.getInputStream());
Gson gson = new GsonBuilder().create();
// The TypeToken is needed when Generics are involved
Type typeOfHashMap = new TypeToken<Map<String, String>>() {}.getType();
Map<String, String> myMap = gson.fromJson(jsonString, typeOfHashMap);