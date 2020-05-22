import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RobusterClient {
    public static void usage() { /// Methode Usage definiert
        System.out.print("usage:");
        System.out.println("\t Client [< connect IP >] [< connect port >]"); /// Druck die Nutzung Ip und Port
    } // usage

    public static void main(String[] args) throws Exception {
        if (args.length > 2) { /// Wenn args.length größer 2 dann usage aufrufen
            usage(); // Druckt aktuelle IP und Port
            System.exit(1);
        } // if

        InetAddress address; /// InetAddress adress als Name
        if (args.length > 0) // größer 0 dann args.length aufrufen
            address = InetAddress.getByName(args[0]);
        else
            address = InetAddress.getByName("127.0.0.1"); /// Holle Die Ip Adresse mit diesem Namen 127.....

        int port;
        if (args.length > 1) {
            port = Integer.parseInt(args[1]); /// was macht parseInt ? Wandle in int um
            if (port <= 0 || port > 65535) { ///
                System.err.println(" Port liegt nicht im gültigen Bereich!");
                System.exit(1);
            } // if
        }
        else
            port = 1234; /// Port 1234 festgelegt 

        DatagramSocket sock = new DatagramSocket();
        byte [] buffer = new byte[1];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
        sock.send(packet);
        System.out.println("Client hat Request versendet! ");

        sock.receive(packet);
        System.out.print("Server-Antwort von ");
        System.out.print(packet.getAddress().toString() + ": ");
        System.out.println(packet.getPort());

        sock.close();
    }
}