serial.notifyOnDataAvailable(true);
serial.addEventListener(this);

public void serialEvent(final SerialPortEvent arg0) {
    try {
        if (arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            //read from the input stream;
        }
    } catch (final Exception e) {
        e.printStackTrace();
    }
}