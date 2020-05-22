// Java runtime
Runtime runtime = Runtime.getRuntime();
// Command
String command = "I:/Release/program.exe" ;
// Process
Process process = runtime.exec(command, null, new File("I:/Release"));