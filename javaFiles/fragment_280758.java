Calendar now = Calendar.getInstance();
    Calendar then = Calendar.getInstance();
    then.set(Calendar.MONTH, month);
    then.set(Calendar.DAY_OF_MONTH, day);
    then.set(Calendar.HOUR, hour);
    then.set(Calendar.MINUTE, minute);

    long dif = then.getTimeInMillis() - now.getTimeInMillis();

    ActionListener action = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if(!alarm.isStopped())
            alarm.stop();
    }
    };

    Timer timer = new Timer((int)dif, action);
    timer.start();