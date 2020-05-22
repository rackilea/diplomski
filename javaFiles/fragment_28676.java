String myData = "{\"username\":\"username\",\"password\":\"password\"}";
URL url = new URL ("https://api.url.com/api/token/");

HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/json; utf-8");
conn.setRequestProperty("Accept", "application/json");
conn.setDoOutput(true);

try(OutputStream outputStream = conn.getOutputStream()) {
    byte[] input = myData.getBytes("utf-8");
    outputStream.write(input, 0, input.length);           
}