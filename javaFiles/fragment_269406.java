URL url = new URL("http://demo.url.com/api");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setDoOutput(true);
conn.setRequestProperty ("Authorization", "Basic dGVzdGVyOjEfhdjkejlhMmU4MjNjNDc=");
conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

OutputStream os = conn.getOutputStream();
BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
writer.write("{grant_type=client_credentials}");
writer.flush();
writer.close();
os.close();
conn.connect();