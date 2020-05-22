final Timer timer = new Timer(); 

    ...
    if (ass.checkAssistenza()) {
        timer.cancel();
        return;
    }