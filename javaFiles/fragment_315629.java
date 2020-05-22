StringBuilder result = new StringBuilder();
String line;
while((line = reader.readLine()) != null)
{
    result.append(line);
}
reader.close();
return result.toString();