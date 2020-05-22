public class Main {

    public static void main(String[] args) throws CaptureDeviceLookupException {
        Capture cap = new Capture();
        cap.doCapture();
    }
}

class PingListener implements PacketListener {

    @Override
    public void packetArrived(Packet packet) {
        try {
            // only ICMP packages
            if (packet instanceof ICMPPacket) {
                ICMPPacket tcpPacket = (ICMPPacket) packet;
                int data = tcpPacket.getMessageCode();
                // only echo request packages
                if (data == ICMPMessages.ECHO) {
                    // print source and destination.
                    String srcHost = tcpPacket.getSourceAddress();
                    String dstHost = tcpPacket.getDestinationAddress();
                    System.out.println("Ping from: " + srcHost + " to " + dstHost);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Capture {
    public void doCapture() {
        // create capture instance
        PacketCapture capture = new PacketCapture();
        // add listener that handles incomming and outgoing packages
        PingListener pingListener = new PingListener();
        capture.addPacketListener(pingListener);
        // m_pcap.setFilter("filter here or in handler", true);

        try {
            capture.open("\\Device\\NPF_{...}", true); // connect capture to device
            while (true) {
                capture.capture(1); // capture one package
            }
        } catch (Exception e) {
            e.printStackTrace(); // exception during capture or handling of
                                 // packages
        } finally {
            // technically never reached as the loop goes on forever.
            // if loop terminates after a while then:

            // remove listener
            capture.removePacketListener(pingListener);
            // end capture (only necessary, if PacketCapture still waits for
            // other packages)
            capture.endCapture();
            // close connection to capture device
            capture.close();
        }
    }
}