Socket socket = new Socket();

try {
    Process process = Runtime.getRuntime().exec("arp -i en0 -a -n");
    process.waitFor();
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

    while (reader.ready()) {
        String ip = reader.readLine();
        ip = ip.substring(3, ip.indexOf(')'));

        try {
            socket.connect(new InetSocketAddress(ip, 1234), 1000);
            System.out.println("Found socket!");
        } catch (ConnectException | SocketTimeoutException ignored) {

        }
    }

    if (socket == null) {
        System.err.println("Could not find socket.");
    }
} catch (Exception e) {
    e.printStackTrace();
}