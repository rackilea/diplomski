private void playSound() {
    Runnable soundPlayer = new Runnable() {

        @Override
        public void run() {
            try {
                clip.setMicrosecondPosition(0);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    new Thread(soundPlayer).start();
}