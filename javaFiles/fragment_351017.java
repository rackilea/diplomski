import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


public class Client
{
    public static void main(String[] args) throws Exception
    {
        SSLSocketFactory socketBuilder = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) socketBuilder.createSocket("127.0.0.1", 4000);
    }
}