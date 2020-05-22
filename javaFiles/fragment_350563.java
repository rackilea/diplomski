List<String> command = new ArrayList<String>();
    command.add("java -jar xxxxx.jar");
    command.add("argument to Main method");
    command.add("another argument to Main method");

    ProcessBuilder builder = new ProcessBuilder(command);

    File workingDirectory = new File("/myworkingdirectory");
    builder.directory(workingDirectory);

    Process process = builder.start();