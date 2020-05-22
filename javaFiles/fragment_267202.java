public class SerialDataReader {

static SerialPort serialPort;
private static final int DATA_RATE = 9600;
private static final String PORT_NAME = "COM4";

public static void main(String[] args) {
    SerialDataReader serialDataReader = new SerialDataReader();
}

public SerialDataReader() {
    serialPort = new SerialPort(PORT_NAME);
    try {
        serialPort.openPort();
        serialPort.setParams(DATA_RATE, 8, 1, 0);

        serialPort.addEventListener(new SerialPortReaderListener());
    } catch (SerialPortException ex) {
        System.out.println(ex);
    }

    Runtime.getRuntime().addShutdownHook(
            new Thread(
                    new Runnable() {
                        public void run() {
                            try {
                                System.out.println("Closing...... : SerialDataReader");
                                serialPort.removeEventListener();
                                serialPort.closePort();
                            } catch (SerialPortException e) {
                                e.printStackTrace();
                            }
                        }
                    }));

}

private class SerialPortReaderListener implements SerialPortEventListener {
    public SerialPortReaderListener() {
        System.out.println("Starting..... : Serial port listener");
    }

    public void serialEvent(SerialPortEvent event) {
        StringBuilder stringBuilder = new StringBuilder();
        char singleChr;
        try {
            singleChr = (char) (serialPort.readBytes(1)[0]);
            if (singleChr == 'h') {
                do {
                    stringBuilder.append(singleChr);
                    singleChr = (char) (serialPort.readBytes(1)[0]);
                } while (singleChr != '\n');

                String strOutput = stringBuilder.toString();

                double[] valueOutput = StrToDoubleArray(strOutput);
                for (double in : valueOutput) {
                    yourMethode(in);
                }
            }

        } catch (SerialPortException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    private double[] StrToDoubleArray(String in) {
        String[] strArray = in.split(",");

        if (!strArray[0].equals("h") || strArray.length != 7) {
            return new double[0];
        }

        double[] output = new double[6];
        for (int i = 0; i < output.length; i++)
            output[i] = Double.parseDouble(strArray[i + 1]);

        return output;
    }
}


}