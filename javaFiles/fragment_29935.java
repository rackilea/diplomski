ds = new DataSource();
ds.setPoolProperties(p);
PipedWriter pipedWriter = new PipedWriter();
ds.setLogWriter(new PrintWriter(pipedWriter));

Runnable runnable = () -> {
    // setup a Reader for reading the DataSource's log output
    try (BufferedReader bufferedReader = new BufferedReader(new PipedReader(pipedWriter))) {
        // start reading from PipedReader, so that writing to PipedWriter will not block
        String line = bufferedReader.readLine();
        while (line != null) {
            analyzeLog(line);
            line = bufferedReader.readLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
};
new Thread(runnable).start();