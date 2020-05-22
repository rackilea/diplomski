private void blink() {
    PrintLog.log("On", "Blink Thread");

    if (treadRunning) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 1000;    //in milissegunds
                try {
                    Thread.sleep(timeToBlink);
                } catch (Exception e) {
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (text_ATMCardInstruction.getVisibility() == View.VISIBLE) {
                            text_ATMCardInstruction.setVisibility(View.INVISIBLE);
                        } else {
                            text_ATMCardInstruction.setVisibility(View.VISIBLE);
                        }
                        blink();
                    }
                });
            }
        }).start();
    } else {
        PrintLog.log("On", "Blink Thread Stop");
        new Thread(new Runnable() {
            @Override
            public void run() {
                text_ATMCardInstruction.setVisibility(View.INVISIBLE);
            }
        }).interrupt();
    }
}