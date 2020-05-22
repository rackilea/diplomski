public class UDPConnectionManager {
    private UDPConnectionManager() { ... }
    public static UDPConnectionManager instance() { ... }

    public void send(String message) {
        if(udp != null) {
            udp.send(message);
        }
    }
}