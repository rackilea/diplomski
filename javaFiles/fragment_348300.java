private static void monitorFile(File file) throws IOException {
    final int POLL_INTERVAL = 1000;
    FileReader reader = new FileReader(file);
    BufferedReader buffered = new BufferedReader(reader);
    try {
      while(true) {
        String line = buffered.readLine();
        if(line == null) {
          // end of file, start polling
          Thread.sleep(POLL_INTERVAL);
        } else {
          System.out.println(line);
        }
      }
    } catch(InterruptedException ex) {
     ex.printStackTrace();
    }
  }