public void remove(final Card card1, final Card card2) {
    new Thread() {
        @Override
        public void run() {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
            }
            card1.hide();
            card2.hide();
        }
    }.start();
}