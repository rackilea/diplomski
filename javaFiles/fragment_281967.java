ExecutorService threadPool = Executors.newFixedThreadPool(10);
...
threadPool.submit(new Runnable() {
    // you could create your own Runnable class if each one needs its own httpClient
    public void run() {
          StringEntity entity = new StringEntity(message);
          ...
          // we assume that the client is some sort of pooling client
          httpClient.execute(method).getEntity().getContent().close();
      }
    }
});