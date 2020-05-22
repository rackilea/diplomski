import java.io.IOException;
import java.net.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;

public class RestrictedRMIRegistry implements RMIServerSocketFactory {
    public static void main(String... args) throws IOException {
        int port = (args.length == 0 ? 1099 : Integer.parseInt(args[0], 10));
        RMIClientSocketFactory csf = RMISocketFactory.getDefaultSocketFactory();
        RMIServerSocketFactory ssf = new RestrictedRMIRegistry();

        LocateRegistry.createRegistry(port, csf, ssf);
    }

    public ServerSocket createServerSocket(int port) throws IOException {
        // Tricky bit; make a server socket with bound address
        return new ServerSocket(port, 0, InetAddress.getLocalHost());
    }
}