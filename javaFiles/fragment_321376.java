@PostContextCreate
    void postContextCreate(final IEventBroker eventBroker){  
        System.out.println("CALLED!");

        final Display display = Display.getDefault();
        Display.getDefault().asyncExec(new Runnable()
        {
          public void run()
        { 
         final Shell shell = createSplashShell(display);  
         shell.open();  
         while (!shell.isDisposed ()) {  
         if (!display .readAndDispatch ()) display.sleep ();  
        }
      }
    }