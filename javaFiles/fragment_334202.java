...
        final Timer timer = new Timer(true); // use daemon thread.
        field.addKeyListener(new KeyAdapter() {
            private TimerTask task;
            @Override
            public void keyTyped(KeyEvent e) {
                if(task != null)task.cancel();
                task = new TimerTask() {
                    @Override
                    public void run() {
                        status.setText("Search: " + field.getText());
                    }
                };
                timer.schedule(task, 1000);
            }
        });