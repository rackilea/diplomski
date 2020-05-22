public void action() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                this.repaint();
            }
        }).start();
    }