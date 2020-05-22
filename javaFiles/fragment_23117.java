int numberOfEmptyIds = 0;
int maxNumberOfAttempts = 5;
boolean urlSent = false;
long timeoutInMillis = 10000; // let's say 10000 millis, equivalent to 10 seconds
Timer timer = null;

public void connect(String portName) throws Exception {
    ...
    scheduleTimer();
}

public void serialEvent(SerialPortEvent evt) {
    if(evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        try {
            while(in.read(buffer) > -1) {
                String asHexStr = DatatypeConverter.printHexBinary(buffer);
                if(asHexStr.contains("FB1")) {
                    scheduleTimer();
                    numberOfEmptyIds = 0;

                } else {
                    numberOfEmtyIds++;
                    if(numberOfEmptyIds == maxNumberOfAttempts && !urlSent) {
                        // send the url here
                    }
                }             
            }
        } catch (IOException ex) {
           // Log the exception here
        }
    }
}

private void scheduleTimer() {
    if(timer != null) {
        timer.cancel();
    }
    timer = new Timer("Timeout");
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if(!urlSent) {
                // send the url here
            }
        }
    };
    timer.schedule(task, timeoutInMillis);
}