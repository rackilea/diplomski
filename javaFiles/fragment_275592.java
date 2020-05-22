public class MulticastReceiver implements Runnable
{
    DatagramSocket socket = null;
    DatagramPacket inPacket = null;
    public MulticastReceiver()
    {
        try
        {
            socket = new DatagramSocket(WifiConstants.PORT_NO_RECV);
        }
        catch(Exception ioe)
        {
            System.out.println(ioe);
        }
    }
    @Override
    public void run()
    {
        byte[] inBuf = new byte[WifiConstants.DGRAM_LEN];

        //System.out.println("Listening");
        inPacket = new DatagramPacket(inBuf, inBuf.length);
        try
        {
            socket.setSoTimeout(3000)
            socket.receive(inPacket);
            String msg = new String(inBuf, 0, inPacket.getLength());
            Log.v("Received: ","From :" + inPacket.getAddress() + " Msg : " + msg);
            DeviceDetails device = getDeviceFromString(msg);
            DeviceManagerWindow.addDevice(device);