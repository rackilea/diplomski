public static class SerialReader implements Runnable 
{
    SerialPort serialPort;

    public SerialReader ( SerialPort serialPort )
    {
        this.serialPort = serialPort;
    }

    public void run ()
    {
        byte[] buffer = new byte[1024];
        int len = -1;
        try
        {
            while ( ( len = serialPort.getInputStream().read(buffer)) > -1 )
            {
                System.out.print(new String(buffer,0,len));
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }            
    }
}