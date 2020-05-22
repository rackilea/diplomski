class WaitThread extends Thread {
    CallBackObj callback;

    public WaitThread(CallBackObj callback) {
      this.text = callback;
      // assume CORBA stuff initiated here
    }

    public void run() {
      Object expectedObj = null;
      do
      {
         try { expectedObj = ncRef.resolve_str("expectedToBeInNameService"); } 
         catch (NotFound e) {}
         Thread.sleep(2000);
      } while(expectedObj == null;
      callback.notifyMethodExample();
    }
  }