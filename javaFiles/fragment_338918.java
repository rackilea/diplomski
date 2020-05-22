buttonStart.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    green.setFill(Color.GREEN);

                    Thread.sleep(3000L);
                    green.setFill(Color.GRAY);
                    yellow.setFill(Color.YELLOW);

                    Thread.sleep(3000L);
                    yellow.setFill(Color.GRAY);
                    red.setFill(Color.RED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
});