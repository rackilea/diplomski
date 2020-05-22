StringBuilder builder = new StringBuilder();
String line;
while ((line = input.readLine()) != ""){
    builder.append(line);
}
Log.i("data", builder.toString());