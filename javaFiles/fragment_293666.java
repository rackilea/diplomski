StringBuilder output = new StringBuilder();
Process p = Runtime.getRuntime().exec("netsh advfirewall show allprofiles state");
p.waitFor(); //Wait for the process to finish before continuing the Java program.

BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line = "";           
while ((line = reader.readLine()) != null) {
  output.append(line + "\n");
}
//output.toString() will contain the result of "netsh advfirewall show all profiles state"