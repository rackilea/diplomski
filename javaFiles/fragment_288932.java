BufferedReader reader = new BufferedReader(new   InputStreamReader(request.getInputStream()));
String line = "";
StringBuilder stringBuilder = new StringBuilder();
while ( (line=reader.readLine()) != null ) {
    stringBuilder.append(line).append("\n");
}

String retval = stringBuilder.toString();