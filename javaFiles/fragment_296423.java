StringBuilder sb = new StringBuilder();
String line;
while ((line = bufferedReader.readLine()) != null)
{
    sb.append(line);
}
query = sb.toString();