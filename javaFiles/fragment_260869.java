public class PortHandler {

    private final SerialPort serialPort;

    public PortHandler(SerialPort serialPort) {
      this.serialPort = serialPort;
    }

    [...]

    public void openConnection() throws SerialPortException {
      serialPort.openPort();
      configureConnectionParameters(serialPort);
      configureReadListener(serialPort);
    }

    [...]
}