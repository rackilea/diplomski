ExecutorService exec = Executors.newFixedThreadPool(threadPoolSize);

while (true) {
   try {
      Socket sock = server.accept();
      exec.submit(new FTPProtocol(sock));
   } catch (IOException e) {
      System.err.println(e.getMessage());
      return;
   }
}