BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
StringBuilder fullResponse = new StringBuilder();
String str;
while ((str = in.readLine()) != null) {
  fullResponse.append(str);
}