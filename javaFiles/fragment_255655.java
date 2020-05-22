handler.post(new Runnable() {
           @Override
           // this will run on the main thread.
           public void run() {
               hideProgressDialog();
           }
      });