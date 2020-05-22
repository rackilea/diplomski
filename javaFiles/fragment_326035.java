BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String line = null;

StringBuilder responseData = new StringBuilder();
while((line = in.readLine()) != null) {
    responseData.append(line);
}