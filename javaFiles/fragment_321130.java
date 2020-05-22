new java.util.Timer().schedule( 
    new java.util.TimerTask() {
        @Override
        public void run() {
            new sample().setVisible(true);
        }
    }, 
    2000 
);