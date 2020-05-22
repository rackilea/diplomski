ArrayList<String> output = new ArrayList<String>()
Process p = Runtime.getRuntime().exec("reg query \"HKLM\\Software\\Microsoft\\Internet Explorer\" /v Version");
BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()),8*1024);
BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()))
String s = null;
System.out.println("Here is the standard output of the command:\n");
while ((s = stdInput.readLine()) != null)
output.add(s)

String internet_explorer_value = (output.get(2));
String version = internet_explorer_value.trim().split("   ")[2];
System.out.println(version);