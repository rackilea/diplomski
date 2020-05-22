public void run() {
    try {
        while (true) {
            // check for interrupts in the loop, or somewhere in the work method
            if (Thread.interrupted()) {
                throw new MyInterruptedException("Important thread interrupted.");
            }
            doMyBackgroundWork();
            sleep();
        }
    }
    catch(Exception e){
        ExceptionHandler.logAndSendException(e);
        if(crashedListener != null){
            crashedListener.onThreadCrashed();
        }
    }
    catch(MyInterruptedException i) {
        LOG.i("Execution stopping because of interrupt.");
    }
}

private void sleep() {
    try {
        sleep(frequency);
    } catch (InterruptedException e) {
        throw new MyInterrptedException(e);
    }
}