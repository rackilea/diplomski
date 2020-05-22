public void Disconnect() throws IOException
    {        
        inStream.close();
        outStream.close();
        Connection.close();
        inStream = null;
        outStream = null;
        Connection = null;
    }