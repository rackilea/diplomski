String myvar = "TextTextText";

final Runtime rt = Runtime.getRuntime();
String[] commands = {"powershell.exe", "Set-Variable", "-Name \"myvar\" -Value \""+myvar+"\";", "echo $myvar"};

Process proc = rt.exec(commands);

BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

String s = null;

while ((s = stdInput.readLine()) != null) {
    System.out.println(s);
}

while ((s = stdError.readLine()) != null) {
    System.out.println(s);
}