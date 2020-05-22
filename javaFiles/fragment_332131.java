import java.net.InetAddress;

public class GetIPAddress {
    public static void main(String[] args) {
        try {
            InetAddress thisIp = InetAddress.getLocalHost();
            System.out.println("IP:" + thisIp.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}