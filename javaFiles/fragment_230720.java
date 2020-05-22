Timer timer = new Timer();
timer.schedule(new TimerTask() {

        @Override
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    label.setText("");
                }
            });

        }
    }, 3000);