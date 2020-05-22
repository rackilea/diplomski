ScheduledExecutorService e= Executors.newSingleThreadScheduledExecutor();
e.scheduleAtFixedRate(new Runnable() {
  @Override
  public void run() {
    // do stuff
    SwingUtilities.invokeLater(new Runnable() {
       // of course, you could improve this by moving dateformat variable elsewhere
       DateFormat dateandtime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       Date date = new Date();
       CurrentDateTime.setText(dateandtime.format(date));
    });
  }
}, 0, 1, TimeUnit.SECONDS);