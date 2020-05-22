int time = 10;

    System.out.println(String.format("time: %,.2f", time));

    if(!tOn) {
             tOn = true;
             Timer.schedule(new Task() {

                @Override
                public void run() {
                     time--;
                     if(time == 0){
                       currentState = GameState.GAMEOVER;
                     }
                }
             }, 10);
        }