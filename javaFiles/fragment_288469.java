Thread t = new Thread() {
    @Override
    public void run() {
      myImg.color2gray();
  }
};
t.start();