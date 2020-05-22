String[] command = {"/usr/bin/open", "/Applications/Utilities/System Profiler.app"};
Process proc = Runtime.getRuntime().exec(command);
int resultCode = proc.waitFor();
if (resultCode != 0) {
    throw new Exception("failed to open system profiler");
}