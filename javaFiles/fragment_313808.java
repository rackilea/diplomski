void execute(Runnable runnable) {
    // do validation
    // do preProcess
    new Thread(runnable).start();
    // do postProcess
  }
...
  void methodA() {
    execute(new Runnable() {
      @Override
      void run() {
        service.methodA();
      }
    });
  }