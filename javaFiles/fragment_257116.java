URL url;//init with your url
BufferedReader br = new BufferedReader(url.openConnection().getInputStream());
StringBuilder builder = new StringBuilder("");
String line;

while((line = br.readLine()) != null)
    builder.append(line);

is.close();

return builder.toString();