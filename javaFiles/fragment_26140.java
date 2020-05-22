final ExecutorService executor = Executors.newFixedThreadPool(2);

    final FilePoller poller = ...
    final FileProcessor processor = ...

    new Thread(new Runnable() 
      { 
        @Override
        public void run() 
        {
          while (true)
          {
            final File file = poller.pollForFile();
            executor.submit(new Runnable() { public void run() { processor.processFile(file); } } );
          }
        }
      });