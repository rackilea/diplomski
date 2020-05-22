if(lockInput) {
    lockInput = false; //Only want this called once per check

    //Put a timer here do slow the app down and figure out what's going wrong
    new Timer().schedule(
        new TimerTask() {

            @Override
            public void run() {

                //if the screen is locked start listener service else stop listener service (METHODS WITHIN THIS SERVICE HANDLE THIS)
                KeyguardManager secondKeyManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);

                if (secondKeyManager.inKeyguardRestrictedInputMode()) {
                    startListener(); 
                } 
                else if (!secondKeyManager.inKeyguardRestrictedInputMode()) {
                    stopListener();
                }
            }
        }, 100 //Fire of the check almost instantly
    );
}

Thread.sleep(10000); //So we are yeilding to the system, don't want an essential while(true) loop