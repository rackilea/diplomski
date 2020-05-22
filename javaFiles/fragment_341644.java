public class SafeFtpConnectionFactory extends FtpConnectionFactory{

    //define a default timeout
    public static int defaultTimeout = 60000;
    public static synchronized int getDefaultTimeout() {
        return defaultTimeout;
    }
    public static synchronized void setDefaultTimeout(int defaultTimeout) {
        SafeFtpConnectionFactory.defaultTimeout = defaultTimeout;
    }

    public SafeFtpConnectionFactory(EndpointURI uri) {
        super(uri);
    }

    @Override
    protected FTPClient createFtpClient() {
        FTPClient client = super.createFtpClient();

        //Define the default timeout here, which will be used by the socket by default,
        //instead of the 0 timeout hanging indefinitely
        client.setDefaultTimeout(getDefaultTimeout());

        return client;
    }
}