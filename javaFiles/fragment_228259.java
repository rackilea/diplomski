class b1Listener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        gamePlay(0, new Runnable() {
            @Override
            public void run() {
                if (computer.getHealth() <= 0) {
                    frame.remove(mainPanel);
                    frame.setSize(1050, 500);
                    gameEnd(0, null);
                } else if (user.getHealth() <= 0) {
                    frame.remove(mainPanel);
                    frame.setSize(1050, 500);
                    gameEnd(1, null);
                }
            }
        });
    }
}

private void gamePlay(int us, final Runnable doAfter) {
    //...
    if (user.getSpeed() >= computer.getSpeed()) {  //if user's speed is quicker, computer gets attacked first
        //...
        MoveAnimationHandler handler = new MoveAnimationHandler(this, us, user, computer, new Runnable() {
            @Override
            public void run() {
                //...
                doAfter.run();
            }
        });

        Timer timer = new Timer(40, handler);

    } else {
        //...
    }
}