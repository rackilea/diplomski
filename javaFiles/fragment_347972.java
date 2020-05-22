public static void restartApplication()
 {
  while(true){

       final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
       final File currentJar = new File("C:\\Documents and Settings\\XBBKKYL\\My      Documents\\hello3.jar");//UpdateReportElements.class.getProtectionDomain().getCodeSource().get           Location().toURI());

      /* is it a jar file? */
     if(!currentJar.getName().endsWith(".jar"))
       return;

   /* Build command: java -jar application.jar */
    final ArrayList<String> command = new ArrayList<String>();
    command.add(javaBin);
    command.add("-jar");
    command.add(currentJar.getPath());

    final ProcessBuilder builder = new ProcessBuilder(command);
    try {
        builder.start();
    } catch (IOException e) {
       e.printStackTrace();
    }
  }
}