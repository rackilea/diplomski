private byte read() throws SerialPortException{
    byte[] temp = null;
    try {
        temp = this.serialPort.readBytes(1, 100);
        if (temp == null) {
            throw new SerialPortException(this.serialPort.getPortName(),
                    "SerialCOM : read()", "Can't read from Serial Port");
        } else {
            return temp[0];
        }
    } catch (SerialPortTimeoutException e) {
        System.out.println(e);
        e.printStackTrace();
    }
    return (Byte) null;
}