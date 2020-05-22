public static void main(String ar[]) throws UnsupportedEncodingException, IOException{
HttpClient httpclient = new DefaultHttpClient();

    String json="{ \"data\": {" +
                "    \"score\": \"5x1\"," +
                "    \"time\": \"15:10\"" +
                "  }," +
                "  \"registration_ids\": [\"4\", \"8\", \"15\", \"16\", \"23\", \"42\"]" +
                "}";
    HttpPost httpost = new HttpPost("https://android.googleapis.com/gcm/send");
httpost.setHeader("Content-Type", "application/json");
httpost.setHeader("Authorization","YOUR_API_KEY");

httpost.setEntity(new StringEntity(json));
HttpResponse response = httpclient.execute(httpost);
}