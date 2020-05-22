try {
        ProcessBuilder builder = new ProcessBuilder(cmd);
        builder.directory(new File(workDir));
        builder.redirectErrorStream(true);
        process = builder.start();
        // any output?
        sht= new StreamHandlerThread(process.getInputStream(), outBuff);
        sht.start();

        // Wait for is InterruptedException sensitive, so when you want the job to stop, interrupt the thread.
        exitVal = process.waitFor();
        sht.join();
        postProcessing();
        log.info("exitValue: %d", exitVal);
    } catch (InterruptedException ex) {
        log.error("interrupted " + Thread.currentThread().getName(), ex);
        shutdownProcess();