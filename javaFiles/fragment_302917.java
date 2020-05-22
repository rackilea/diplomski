String URL = "http://localhost:8080/"
String serverURL = URL + "servlet?param=" + someParam;
final URL url = new URL(serverURL)
final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setDoOutput(true);
connection.setRequestMethod("POST");

final BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

System.out.println(br.readLine());