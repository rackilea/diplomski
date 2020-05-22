public void startGameAction() {

    //My game actions

    handler = new Handler();
    runnable = () -> {
        if (!Conditions.succesCondition(number)) {
            success();
        } else {
            fail();
        }
    };
    handler.postDelayed(runnable,time);
}

public void success(){
        handler.removeCallbacks(runnable);
        handler = null;

        scoreCount++;
        //other stuff
        startGameAction();
    }

 private void fail() {
    handler.removeCallbacks(runnable);
    //other stuff
}