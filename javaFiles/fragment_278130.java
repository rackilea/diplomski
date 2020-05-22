... copy file code in background thread

 Display.getDefault().asyncExec(new Runnable() {
       public void run() {
          pbar.setSelection (pb+1);
       }
  });