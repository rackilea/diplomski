public class PortCheck {

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(4500, 0, InetAddress.getLocalHost());
            System.out.println("port available");
        } catch (IOException e) {
            System.out.println("port not available");
        }
    }
}