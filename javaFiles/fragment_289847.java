class MyReader
{
     public int read() throws IOException {  
        int bit = current.read();  
        if (bit == -1 && streams.size() > 0) {  
            // left out due to lacking relevance
        } else if(bit == -1 && streams.size() == 0) {
            waitForNextStream();
            return read();
        }
        return bit;
    }

    private synchronized void waitForNextStream()
    {
        // TODO add close handling, set current here
        while (streams.isEmpty())
        {
            wait();
        }
    }


    public synchronized void addNextStream(InputStream is)
    {
        streams.add(is);
        notify();
    }
}