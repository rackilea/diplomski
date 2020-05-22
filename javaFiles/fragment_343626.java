Process p = Runtime.getRuntime().exec("grep \"Exception\" /home/admin/logs/common-error.log |sort |uniq -c |sort -nr
");
p.waitFor();
BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line = "";
StringBuilder output = new StringBuilder();
while ((line = reader.readLine()) != null) {
 output.append(line + "\n");
}
System.out.println(output.toString());