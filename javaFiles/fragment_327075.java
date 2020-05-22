private class ManagedSSLSocketFactory extends SSLSocketFactory
{
    private SSLSocketFactory m_socketFactory;

    public ManagedSSLSocketFactory(SSLSocketFactory socketFactory)
    {
        m_socketFactory = socketFactory;
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException
    {
        Socket socket = m_socketFactory.createSocket(s, host, port, autoClose);

        //Note that m_arcThread, m_arcSocket, etc are defined in the containing class
        if(Thread.currentThread() == m_arcThread)
        {
            if(m_arcSocketInvalid || (socket == m_ssrcSocket))
            {
                closeSocketQuietly(socket);
                return createSocket(s, host, port, autoClose);
            }
            m_arcSocketInvalid = false;
        }

        ... omitted some convoluted code that deals with edge cases

        return socket;
    }

    ... rest of implementation

}