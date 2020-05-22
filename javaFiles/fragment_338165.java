List<String> command = new ArrayList<String>();
    command.add("cmd");
    command.add("/C");
    File dcr = new File("executable/setup.exe");
    dcr.setExecutable(true, false);
    command.add(dcr.getAbsolutePath());
    ProcessBuilder builder = new ProcessBuilder(command);
    builder.redirectErrorStream(true);
    final Process process = builder.start();
    try {
        process.waitFor();
    } catch (InterruptedException ex) {
        Logger.getLogger(WhatEver.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }
    InputStream is = process.getErrorStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line;
    while ((line = br.readLine()) != null) {
        Logger.getLogger(Thumbnail.class.getName()).severe(line);
    }