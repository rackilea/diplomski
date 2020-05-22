final ProcessBuilder processBuilder = new ProcessBuilder("/usr/bin/osascript",
   "-e", "on run argv",
   "-e", "  tell application \"Terminal\" to do script "
            + "\"cd \" & quoted form of item 1 of argv & \" ; "
            + "export PATH=\" & quoted form of item 2 of argv",
   "-e", "end run");

// create a File and use getAbsolutePath to resolve any relative paths
// against this Java process's working directory.
File cdDir = new File(dirParam);

// this argument will be "item 1 of argv" to the AppleScript
processBuilder.command().add(cdDir.getAbsolutePath());

final Map<String, String> environment = processBuilder.environment();
final String path = environment.get("PATH");

File pathPrefix = new File(pathParam);
// and this will be "item 2 of argv"
processBuilder.command().add(
      pathPrefix.getAbsolutePath() + File.pathSeparator + path);

final Process process = processBuilder.start();
process.waitFor();