import java.net.InetAddress;
import java.net.InetSocketAddress;

public class MyInetSocketAddress {

    public static InetSocketAddress myInetSocketAddress(String hostname, int port, boolean needResolved) 
    {
        if (hostname == null || port < 0 || port > 65535) {
            throw new IllegalArgumentException("host=" + hostname + ", port=" + port);
        }
        InetAddress addr = null;
        if (needResolved) {
            try {
                addr = InetAddress.getByName(hostname);
            } 
            catch (Exception ignored) 
            {
            }
        }
        return new InetSocketAddress(addr, port);
    }

}