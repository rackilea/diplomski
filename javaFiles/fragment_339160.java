Timer timer = new Timer();
timer.schedule(new TimerTask() {

    // It's possible that a starting value of false will
    // match your desired behaviour better.
    // Experiment with a situation where there is no connection initially.
    boolean previouslyConnected = true;

    public void run() {
        Platform.runLater(new Runnable() {
            public void run() {
                SqlTransport.openConnectionToDB();
                System.out.println("connect");
                boolean connected = SqlTransport.openConnectionToDB();
                // ! means 'not'. This is typically written instead of 'connected == false'
                if (!connected) {
                    if (previouslyConnected) {
                        alertWindow.display();
                    }
                    caseCount.setVisible(false);
                    System.out.println("noConnection");
                } else {
                    System.out.println("connectDone");
                    caseCount.setVisible(true);
                    caseCount.setText(String.valueOf(SqlTransport.getOpenedCount()));
                    pause.playFromStart();
                    pause.setOnFinished(e -> {
                        SqlTransport.closeConnectionToDB();
                        System.out.println("closeDone");
                    });
                }
                previouslyConnected = connected;
            }
        });
    }
}, 10000, 10000);