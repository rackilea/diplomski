void startHeavyDutyStuff() {

  // Here is the heavy-duty thread
  Thread t = new Thread() {

      public void run() {
          while (true) {

              mResults = doSomethingExpensive();

              //Send update to the main thread
              messageHandler.sendMessage(Message.obtain(messageHandler, mResults)); 
          }

      }
  };
  t.start();
}

// Instantiating the Handler associated with the main thread.
private Handler messageHandler = new Handler() {

      @Override
      public void handleMessage(Message msg) {  
          switch(msg.what) {
              //handle update
              //.....
          }
      }

  };
}