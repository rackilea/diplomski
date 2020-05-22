@Override
    public SOAPMessage sendSOAPMessage(SOAPMessage request) throws Exception
    {
        SOAPConnection soapConnection = SOAPConnectionFactory.newInstance().createConnection();
        URL endpoint =
            new URL(new URL(serviceUrl), "endpoint spec.",
                new URLStreamHandler()
                {
                    @Override
                    protected URLConnection openConnection(URL url) throws IOException
                    {
                        URL target = new URL(url.toString());
                        URLConnection connection = target.openConnection();
                        // Connection settings
                        connection.setConnectTimeout(5000);
                        connection.setReadTimeout(5000);
                        return (connection);
                    }
                });

        return soapConnection.call(request, endpoint);
    }