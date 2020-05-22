public void run()
    {
      phaser.arriveAndDeregister();
      if (isLast.get())
        doSomething(this);
    }