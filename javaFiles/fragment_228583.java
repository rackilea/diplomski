Process p = Runtime.getRuntime().exec("stat -c \"%X\" /path/to/file");
p.waitFor();
BufferedReader reader = new BufferedReader(new InputStreamReader(
  p.getInputStream()));
String line = reader.readLine();
long time_sec = 0;
if (!TextUtils.isEmpty())
 time_sec = Long.parseLong(line);