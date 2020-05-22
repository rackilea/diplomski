public void init() {        
    try { 
        SwingUtilities.invokeAndWait(
            new Runnable() {
                @Override
                public void run() {
                    ActListen actListenInstance = new ActListen(StackApplet.this);
                    actListenInstance.invokePush();
                    actListenInstance.invokePop();
                }
            });
    } catch (Exception e) {
      e.printStackTrace();
    }
}