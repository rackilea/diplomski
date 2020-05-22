URL url = new URL("http://"...);
HttpURLConnection http = (HttpURLConnection)
url.openConnection();
http.setRequestMethod("GET");
http.setDoOutput(true);
http.connect();

OutputStream out = http.getOutputStream();
OutputStreamWriter writer = new OutputStreamWriter(out);
writer.write(FOO);
writer.flush();
writer.close();

InputStreamReader in = new InputStreamReader(http.getInputStream());
BufferedReader br = new BufferedReader(in);

char[] chars = new char[BUF_SIZE];
int size = br.read(chars);

String response = new String(chars).substring(0, size);