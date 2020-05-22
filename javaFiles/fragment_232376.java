new Thread() {
   public void run() {
      while (!quit) {
         try { Thread.sleep(10); } catch(Exception e) { }
      }
      System.err.println("unhook and exit");
      lib.UnhookWindowsHookEx(hhk);
      System.exit(0);
   }
}.start();