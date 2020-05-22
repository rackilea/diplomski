BufferedReader br = new BufferedReader(inputStream); // inputStream in your code
String line;
StringBuilder sb = new StringBuilder();
while ((line = br.readLine()) != null) {
    sb.append(line); 
}
// finished reading
System.out.println("data size = " + sb.length());
JSONObject data = new JSONObject(sb.toString());

// and don't forget finally clauses with closing streams/connections