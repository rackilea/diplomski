List<String> command = new ArrayList<String>();
    command.add("java");
    command.add("ProjectLauncher");
    ProcessBuilder builder = new ProcessBuilder(command);
    builder.redirectErrorStream(true);
    final Process process = builder.start();
        try {
           process.waitFor();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        //if you wish to read the output of it then below code else you can omit it.
        InputStream is = process.getErrorStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            Logger.getLogger(MyClass.class.getName()).severe(line);
        }