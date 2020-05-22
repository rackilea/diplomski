ThreadMultipleDateReceiver thrdMDateReceiver = null;
  ThreadStreamDateWriter thrdSDateWriter0 = null;
  ThreadStreamDateWriter thrdSDateWriter1 = null;
  private void jtbDateExchangerActionPerformed(java.awt.event.ActionEvent evt) {  
    if (jtbDateExchanger.isSelected()) {
      if (thrdMDateReceiver == null) {
        thrdMDateReceiver = new ThreadMultipleDateReceiver();
        thrdMDateReceiver.start();
      }
      if (thrdSDateWriter0 == null) {
        thrdSDateWriter0 = new ThreadStreamDateWriter("-0-", thrdMDateReceiver.getPipedOutputStream());
        thrdSDateWriter0.start();
        thrdMDateReceiver.addDateWriter(thrdSDateWriter0);
      }
      if (thrdSDateWriter1 == null) {
        thrdSDateWriter1 = new ThreadStreamDateWriter("-1-", thrdMDateReceiver.getPipedOutputStream());
        thrdSDateWriter1.start();
        thrdMDateReceiver.addDateWriter(thrdSDateWriter1);
      }
    } else {
      if (thrdMDateReceiver != null) {
        thrdMDateReceiver.stopThread();
      }
    }
  }