void readSocket(Socket socket)
{
    try
    {
        byte[] data = new byte[8];
        int ret;
        while (true)
        {
            int offset=0;
            // keep reading until we got 8 bytes
            while (offset < data.length)
            {
                // when read returns 0 means the socket is closed.
                // if return < 0 there is an error in both cases we must quit.
                if ((ret = socket.getInputStream().read(data, offset, data.length-offset)) <= 0) return;
                offset+=ret;
            }
            // We got 8 bytes, process them
            // ... and loop for next packet
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
        // there is an error in the socket, quit.
        return;
    }
}