final ProcessBuilder processBuilder = new ProcessBuilder(
      "/usr/bin/osascript", "-e");
final Map<String, String> environment = processBuilder.environment();
final String path = environment.get("PATH");
processBuilder.command().add("tell application \"Terminal\" to do script \"" +
    "cd /Volumes ; export PATH=\\\"/mypath:" + path + "\\\\"\"");
final Process process = processBuilder.start();
process.waitFor();