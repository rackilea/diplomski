String cmd = "which "+<insert executable to find>; // linux
String cmd = "where "+<insert executable to find>; // windows

Process p = Runtime.getRuntime().exec(cmd);

BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
// read the output from the command
while ((s = stdInput.readLine()) != null) {
    ref.log.setText(ref.log.getText()+s+"\n");
    ref.updateDisplay();
}
// read any errors from the attempted command
while ((s = stdError.readLine()) != null) {
    ref.log.setText(ref.log.getText()+s+"\n");
    ref.updateDisplay();
}