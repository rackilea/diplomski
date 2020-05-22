String json_response = "";
InputStreamReader in = new InputStreamReader(con.getInputStream());
BufferedReader br = new BufferedReader(in);
String text = "";
while ((text = br.readLine()) != null) {
  json_response += text;
}