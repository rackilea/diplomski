String antHome = System.getenv().get("ANT_HOME");
String antExecutable = antHome + File.separator + "bin" + File.separator + "ant.bat";

List<String> command = new ArrayList<String>();
command.add(antExecutable);
command.add("mytarget");
command.add("-Darg1="+arg1);
command.add("-Darg2="+arg2);
command.add("-propertyfile");
command.add("myproperty.properties");

ProcessBuilder processBuilder = new ProcessBuilder(command);
processBuilder.directory(new File("E:/ant_demo")); // set working directory
Process process = processBuilder.start(); // run process

// get an input stream connected to the normal output of the process
InputStream inputStream = process.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
String line = null;
while (( line = reader.readLine ()) != null) {
    System.out.println(line);
}
System.out.println("Ant file executed");
...
...
System.out.println("Completed");