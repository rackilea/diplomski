String defaultPort = "COM1"; 
        String driverName = "com.sun.comm.Win32Driver";
        javax.comm.CommDriver driver = null;

        try 
        {
            driver = (javax.comm.CommDriver) Class.forName(driverName).newInstance();
            driver.initialize();

            portId1 = CommPortIdentifier.getPortIdentifier("COM1");
            serialPort1 = (SerialPort) portId1.open("Principal", 2000);
            serialPort1.setSerialPortParams(115200,SerialPort.DATABITS_8, SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
            outputStream = serialPort1.getOutputStream();
            String texto = "Testando envio \n";
            byte[] envio = texto.getBytes();
            outputStream.write(envio);
        } 
        catch (Exception e) {System.err.println (e);}