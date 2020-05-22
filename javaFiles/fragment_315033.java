import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UdpBroadcaster {

private static final Logger LOGGER = LoggerFactory.getLogger(UdpBroadcaster.class);

private static final int PORT = 9876;
private static final String MCAST_ADDR = "FF7E:230::1234";

private static InetAddress GROUP;

public static void main(String[] args) {
    try {
        GROUP = InetAddress.getByName(MCAST_ADDR);
        Thread server = server();
        server.start();
        Thread.sleep(3000);
        Thread client = client();
        client.start();
        client.join();
    } catch (Exception e) {
        LOGGER.error("Usage : [group-ip] [port]");
    }
}

private static Thread client() {
    return new Thread(new Runnable() {
        public void run() {
            MulticastSocket multicastSocket = null;
            try {
                multicastSocket = new MulticastSocket(PORT);
                multicastSocket.joinGroup(GROUP);
                while (true) {
                    try {
                        byte[] receiveData = new byte[256];
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        multicastSocket.receive(receivePacket);
                        LOGGER.info("Client received from : " + receivePacket.getAddress() + ", " + new String(receivePacket.getData()));
                    } catch (Exception e) {
                        LOGGER.error(null, e);
                    }
                }
            } catch (Exception e) {
                LOGGER.error(null, e);
            } finally {
                multicastSocket.close();
            }
        }
    });
}

private static Thread server() {
    return new Thread(new Runnable() {
        public void run() {
            DatagramSocket serverSocket = null;
            try {
                serverSocket = new DatagramSocket();
                try {
                    while (true) {
                        byte[] sendData = new byte[256];
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, GROUP, PORT);
                        serverSocket.send(sendPacket);
                        ThreadUtilities.sleep(1000);
                    }
                } catch (Exception e) {
                    LOGGER.error(null, e);
                }
            } catch (Exception e) {
                LOGGER.error(null, e);
            }
        }
    });
}

}