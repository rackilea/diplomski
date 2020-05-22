private static void alarmClock(final AlarmGUI aGUI) {
    Timer alarmClock = new Timer();
    TimerTask timer = new TimerTask() {

        @Override
        public void run()
        {
          aGUI.setTimeLabel(getTime());
        }
    };
    alarmClock.scheduleAtFixedRate(timer, 0, 1);
}

public static void main(String[] args) {
    AlarmGUI a = new AlarmGUI();
    alarmClock(a);
    a.setVisible(true);
}