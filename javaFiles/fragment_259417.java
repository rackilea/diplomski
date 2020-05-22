StringBuilder inputStringBuilder = new StringBuilder();
BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

String line;
while ((line = br.readLine()) != null) {
    inputStringBuilder.append(line);
}
String htmlString = inputStringBuilder.toString();