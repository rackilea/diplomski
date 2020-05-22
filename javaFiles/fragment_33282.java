Timer timer = new Timer("Display Timer");

TimerTask task = new TimerTask() {
    @Override
    public void run() {
        // Task to be executed every second
        try {
            SwingUtilities.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    Calendar cali = Calendar.getInstance();
                    cali.getTime();
                    String time = timeFormat.format(cali.getTimeInMillis());
                    System.out.println(timeFormat.format(cali.getTimeInMillis()));
                    jLabel4.setText(time);

                }
            });
        } catch (InvocationTargetException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
};

// This will invoke the timer every second
timer.scheduleAtFixedRate(task, 1000, 1000);