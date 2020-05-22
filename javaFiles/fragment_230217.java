long waitUntilTime = -1L;
    public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
        long time = System.currentTimeMillis();
        if (time >= waitUntilTime) {
          waitUntilTime = time + TIME_TO_IGNORE_EVENTS;
          processEvent(event);
        }
    }