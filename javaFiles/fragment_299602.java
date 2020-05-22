inputStream = s.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
StringBuilder sb = new StringBuilder();
int ch;

do
{
    ch = reader.read();
    if (ch <= 0) break;
    sb.append((char)ch);
}
while (true);
String username = sb.toString();

sb.setLength(0);
do
{
    ch = reader.read();
    if (ch <= 0) break;
    sb.append((char)ch);
}
while (true);
String password = sb.toString();