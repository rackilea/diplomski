private Instant lastActive;

....

   lastActive = Instant.now();

   final Listener listener = new Listener()
    {
      @Override
      public void handleEvent(final Event event)
      {
        lastActive = Instant.now();
      }
    };

   display.addFilter(SWT.MouseMove, listener);
   display.addFilter(SWT.KeyDown, listener);
   // TODO more filters if required

   final Runnable timer = new Runnable()
    {
      @Override
      public void run()
      {
        final Instant now = Instant.now();

        if (ChronoUnit.SECONDS.between(lastActive, now) > xxx) {  // Number of inactive seconds here
          System.out.println("inactive");  // Inactive code here
        }
        else {
          display.timerExec(1000, this);
        }
      }
    };

   display.timerExec(1000, timer);

   ... create/open shell ...

   while (!shell.isDisposed())
    {
      if (!display.readAndDispatch())
        display.sleep();
    }