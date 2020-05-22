BufferedReader br = new BufferedReader(new InputStreamReader(is.getInputStream()));
StringBuilder sb = new StringBuilder();
String inputLine = "";
while ((inputLine = br.readLine()) != null) {
    sb.append(inputLine);
}
String result = sb.toString();