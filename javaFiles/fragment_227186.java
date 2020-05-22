final CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("COM1");

final SerialPort com1 = (SerialPort)portId.open("Test", 1000);
final InputStream in = com1.getInputStream();

com1.notifyOnDataAvailable(true);
com1.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
com1.addEventListener(new SerialPortEventListener() {
    public void serialEvent(SerialPortEvent event) {
        if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                byte[] buffer = new byte[4096];
                int len;
                while (-1 != (len = in.read(buffer))) {
                    // do something with buffer[0..len]
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
});