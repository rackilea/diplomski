final ProcessBuilder processBuilder = new ProcessBuilder("/usr/bin/osascript",
   "-e", "on run argv",
   "-e", "  set currentdir to (do shell script \"pwd\")",
   "-e", "  set currentpath to (do shell script \"echo $PATH\")",
   "-e", "  tell application \"Terminal\" to do script \""
            + "cd \" & quoted form of currentdir & \" ; ""
            + "cd \" & quoted form of item 1 of argv & \" ; "
            + "export PATH=\" & quoted form of currentpath",
   "-e", "end run",
   dirParam);

final Map<String, String> environment = processBuilder.environment();
final String path = environment.get("PATH");
environment.put("PATH", pathParam + File.pathSeparator + path);

final Process process = processBuilder.start();
process.waitFor();