Uri uri = Uri.parse(addressM)
  .buildUpon()
  .appendQueryParameter("q", message)
  .build();
URL url = new URL(uri.toString());
connection = (HttpURLConnection) url.openConnection();
connection.setRequestProperty("Authorization", "Bearer " + myAccessToken);
connection.setRequestMethod("POST");
connection.connect();