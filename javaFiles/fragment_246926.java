public class PortScanner {
    public static void main(String[] args) throws Exception {

        final String host = "localhost";
        final InetAddress inetAddress = InetAddress.getByName(host);
        final String hostName = inetAddress.getHostName();
        final List<int> openPorts = new ArrayList();

        // we begin at port 1 because port 0 is never used
        for (int port = 1; port <= 200; port++) {
            try {
                Socket socket = new Socket(hostName, port);
                openPorts.add(port);
            } catch (IOException) {
            } finally {
                socket.close();
            }
        }
    }
}