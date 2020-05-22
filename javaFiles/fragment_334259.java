public synchronized void serialEvent(SerialPortEvent oEvent) {
 if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
    try {
        String inputLine=null;
        if (input.ready()) {
            inputLine = input.readLine();
            System.out.println(inputLine);
        }

    } catch (Exception e) {
        System.err.println(e.toString());
    }
 }
// Ignore all the other eventTypes, but you should consider the other ones.
}