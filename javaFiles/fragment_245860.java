private void startRandomButton(Button button) {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            setButtonRandomPosition(button);
        }
    }, 0, 1000);//Update button every second
}