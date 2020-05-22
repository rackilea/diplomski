HttpURLConnection connection = null;
try {
    URL url = new URL("https://api.myjson.com/bins/r7dj6");
    connection = (HttpURLConnection) url.openConnection();
    connection.connect();
    InputStream inputStream = connection.getInputStream();

    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String line;
    StringBuilder stringBuffer = new StringBuilder();
    while ((line = reader.readLine()) != null){
        stringBuffer.append(line);
    }

    JSONObject jsonObject = new JSONObject(stringBuffer.toString());
    JSONObject apartmentObject = jsonObject.getJSONObject("Apartment");
    Iterator<String> keys = apartmentObject.keys();
    while (keys.hasNext()) {
        String flatName = keys.next();
        JSONObject flat = apartmentObject.getJSONObject(flatName);
        String age = flat.getString("age");
        String color = flat.getString("color");
        String name = flat.getString("name");
        String owner = flat.getString("owner");
        String partner = flat.getString("partner");
        Log.d("Flat", flatName + ": " + age + ", " + color + ", " + name + ", " + owner + ", " + partner);
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (connection != null) {
        connection.disconnect();
    }
}