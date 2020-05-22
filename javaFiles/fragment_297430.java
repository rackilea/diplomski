Process proc = null;
String[] cmd = { "cmd", "/c", "dir" };
proc = Runtime.getRuntime().exec(cmd);

InputStream inputStream = proc.getInputStream();
InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

String line;
while ((line = bufferedReader.readLine()) != null)
{
    System.out.println(line);
}