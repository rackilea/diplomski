SwingUtilities.invokeAndWait(new Runnable() {
  public void run() {
    p1 = new PopUp(); //keep
         p1.setLocation(((int)(Math.random()*2000)), ((int)(Math.random()*1000)));
         popUpsOpen++;
  }
});