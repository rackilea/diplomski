public static void main(String[] args) throws Exception {
    URL url = new URL("http://chartapi.finance.yahoo.com/instrument/1.0/FB/chartdata;type=quote;range=1d/json");
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
    StringBuffer buffer = new StringBuffer();
    if (inputStream == null)
        return;

    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String line;

    while ((line = reader.readLine()) != null) {
        buffer.append(line + "\n");
    }

    String jsonString = buffer.substring(30, buffer.length() - 2);
    JsonObject jobj = new Gson().fromJson(jsonString, JsonObject.class);
    System.out.println(jobj.get("Timestamp").toString());
    System.out.println(jobj.get("labels").toString());
    System.out.println(jobj.get("ranges").toString());
    System.out.println(jobj.get("series").toString());

}