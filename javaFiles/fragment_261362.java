List<String> command = new ArrayList<String>();
command.add("/path/to/Blockland.exe");
command.add("Other arguments");
ProcessBuilder procBuilder = new ProcessBuilder(command);
Process proc = procBuilder.start();

ProcessOutputReader outputReader =
    new ProcessOutputReader(proc.getInputStream());
ProcessOutputReader errorReader =
    new ProcessOutputReader(proc.getErrorStream());

Thread out = new Thread(outputReader);
out.start();

Thread error = new Thread(errorReader);
error.start();

proc.waitFor();