// initialize logging libraries
    File log4jFile = new File("log4j.properties");
    if (log4jFile.exists() & log4jFile.canRead()) {
        PropertyConfigurator.configure("log4j.properties");
    }
    else {
        try {
            InputStream log4jJarstream = Main.class.getResourceAsStream("log4j.properties");
            OutputStream outStream = new FileOutputStream(new File("log4j.properties"));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = log4jJarstream.read(bytes)) != -1) {
                outStream.write(bytes, 0, read);
            }
            log4jJarstream.close();
            outStream.flush();
            outStream.close();

            PropertyConfigurator.configure("log4j.properties");
        }
        catch (Exception e) {
            BasicConfigurator.configure();
            log.warn("Error writing log4j.properties, falling back to defaults.");
            log.warn(e);
            log.warn("STACK TRACE:");
            int i = 0;
            StackTraceElement[] trace = e.getStackTrace();
            while (i < trace.length) {
                log.warn(trace[i]);
                i++;
            }
        }
    }