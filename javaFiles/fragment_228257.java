private void gamePlay(int us) {

    String h1 = "";
    String h2 = "";
    int c;
    do {
        c = aiMove();
    } while (computer.accessMoves(c).getPP() <= 0);

    if (user.accessMoves(us).getPP() <= 0) {
        JOptionPane.showMessageDialog(frame, "The move you selected has no PP left. Select another.");
        return;
    }
    long lastTime = System.currentTimeMillis();
    if (user.getSpeed() >= computer.getSpeed()) {  //if user's speed is quicker, computer gets attacked first
        computer.updateHealth(user, us);
        userMove.setText("You used: " + user.accessMoves(us).getName());
        user.accessMoves(us).lowerPP();
        h2 = healthBar(computer);                       //health bar is changed

        //......
        MoveAnimationHandler handler = new MoveAnimationHandler(this, us, user, computer, new Runnable() {
            @Override
            public void run() {
                pch.setText("Computer's HP: " + h2 + computer.getHealth());
                moveFirst.setText("You attacked first.");

                if (computer.getHealth() == 0) {                  //if computer dies, user wins
                    return;
                }

                /* backS.remove(left);
                 backS.remove(right);
                 left = new ImageComponent(user.getName() + "Left.jpg");
                 right = new ImageComponent(computer.getName() + "Right.jpg");
                 backS.add(left);
                 backS.add(right);
                 backS.repaint();*/
                user.updateHealth(computer, aiMove());
                aiMove.setText("Computer used: " + computer.accessMoves(c).getName() + "                       ");
                computer.accessMoves(c).lowerPP();
                h1 = healthBar(user);
                hu.setText("Your HP: " + h1 + user.getHealth() + "      ");
                if (user.getHealth() == 0) {
                    return;
                }
            }
        });

        Timer timer = new Timer(40, handler);
        timer.start();