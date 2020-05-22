correct.setVisible(true);
timer.schedule(new TimerTask() {
@Override
    public void run() {
    Platform.runLater(new Runnable() {
       public void run() {
          correct.setVisible(false);
      }
    });
}
}, 3*1000);