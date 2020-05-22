URL url = new URL(baseurl);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
if (connection.getResponseCode() == 200) {
  try (InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
      BufferedReader br = new BufferedReader(streamReader);
      Stream<String> lines = br.lines()) {
    lines.forEach(s -> persist(s)); //should be a method reference
  }
}