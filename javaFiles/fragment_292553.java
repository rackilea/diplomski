DatagramSocket socket = null;
    try 
    {
        socket = new DatagramSocket( 50000 );
        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket( buf, buf.length );
        socket.receive( packet );
    } 
    catch (SocketException e1) 
    {
        e1.printStackTrace();
    }
    catch (IOException e) 
    {
        Log.d(TAG, "Error with receiving data");
        e.printStackTrace();
    }