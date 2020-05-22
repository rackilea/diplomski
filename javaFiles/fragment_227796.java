// do something on the UI thread asynchronously
   Display.getDefault().asyncExec(new Runnable() {
      public void run() {
         // access to UI
      }
   });

   // do something on the UI thread synchronously
   Display.getDefault().syncExec(new Runnable() {
      public void run() {
         // access to UI
      }
   });