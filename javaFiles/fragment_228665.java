private void startTimer() {
  timer = new Timer(TIMER_DELAY, new TimerListener());
  timer.start();
}

private class TimerListener implements ActionListener {
  private final String PATTERN = "EEE , dd MMM , HH:mm:ss";
  private final DateFormat S_DATE_FORMAT = new SimpleDateFormat(PATTERN);

  @Override
  public void actionPerformed(ActionEvent e) {
     Date date = Calendar.getInstance().getTime();

     String dateString = S_DATE_FORMAT.format(date);
     clockLabel.setText(dateString);         
  }
}