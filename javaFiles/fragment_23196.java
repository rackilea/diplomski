public static Process createProcess(final String optionsAsString, final String workingDir, final String mainClass, final String[] arguments) throws IOException {
    String jvm = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";

    String[] options = optionsAsString.split(" ");
    List<String> command = new ArrayList<String>();
    command.add(jvm);
    command.addAll(Arrays.asList(options));
    command.add(mainClass);
    command.addAll(Arrays.asList(arguments));

    //System.out.println(command);

    ProcessBuilder processBuilder = new ProcessBuilder(command);
    processBuilder.directory(new File(workingDir));

    return processBuilder.start();
}

public static void makeItRun() {
   try {
      // Start JVM
      String classPath = buildClassPath();
      String workingDir = getSuitableWorkingDir();//or just "."
      Process java = createProcess("-cp \"" + classPath + "\"", workingDir, my.package.APP.class.getCanonicalName(), "-the -options -of -my -APP");

      // Communicate with your APP here ...

      // Stop JVM
      java.destroy();
   } catch(Throwable t) {
      t.printStackTrace();
   }
}