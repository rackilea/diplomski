Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // do the job here
                    if (bot.getValue() <= 16) {
                        neueKarte(new ActionEvent());
                    } else {
                        cancel();
                    } 
                }
            });
        }
    }, 0, 1000);