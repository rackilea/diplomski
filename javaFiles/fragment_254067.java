import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

public class Rxtx
{
    static CommPortIdentifier portId;
    static CommPortIdentifier saveportId;
    static Enumeration  portList;
    static InputStream inputStream;
    static OutputStream outputStream;
    static BufferedInputStream bufferedInputStream;
    static SerialPort serialPort;


    public static void main(String[] args)
    {
        String port = "";
        portList = CommPortIdentifier.getPortIdentifiers();
        String feedback = "";
        String data = "";

        while(portList.hasMoreElements())
        {
            portId = (CommPortIdentifier) portList.nextElement();
            if(portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
            {
                if(portId.getName().equals("COM5"))
                {
                    port = portId.getName();
                    break; // Breaks the loop to next section
                }
            }

        }
        //Cast serialPort
        try
        {
            serialPort = (SerialPort) portId.open("Pruebas", 2000);
        }
        catch(PortInUseException ex)
        {
            ex.printStackTrace();
        }
        //Setup outputStream
        try
        {
            outputStream = serialPort.getOutputStream();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        //set params to serialPort
        try
        {
            serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        }
        catch(UnsupportedCommOperationException ex)
        {
            ex.printStackTrace();
        }
        try
        {
            inputStream = serialPort.getInputStream();
            bufferedInputStream = new BufferedInputStream(inputStream);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        serialPort.notifyOnDataAvailable(true);

       try
       {
            if(!(outputStream == null))
            {
                String serialMessage = "ATZ\r\n"; //Soft reset
                outputStream.write(serialMessage.getBytes());
                String comando = "AT+VCID=1\r\n"; //Caller-Id formatting
                outputStream.write(comando.getBytes());

                byte[] readBuffer = new byte[1024];
                while(true) //Continuously check for data.
                {
                    String getInfo = "";
                    Thread.sleep(100);
                    while(bufferedInputStream.available() > 0)
                    {
                        int numBytes = bufferedInputStream.read(readBuffer);
                        getInfo += new String(readBuffer);
                        data = data + new String(readBuffer, 0, numBytes);
                        data = data.trim();
                    }
                    feedback += getInfo;
                    int length = getInfo.length();
                    System.out.println("data: " + data);
                }

            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}