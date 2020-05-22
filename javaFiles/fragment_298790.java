HttpCommandExecutor ce = (HttpCommandExecutor) ((RemoteWebDriver)driver).getCommandExecutor();
String remoteAddress = ce.getAddressOfRemoteServer().toString();
String localAddress = null;

try (Socket socket = new Socket()) {
    socket.connect(new InetSocketAddress("google.com", 80));
    localAddress = socket.getLocalAddress().getHostAddress();
} catch (IOException e) {
    e.printStackTrace();
}

if (remoteAddress.contains("localhost") || remoteAddress.contains(localAddress)) System.out.println("Local machine");
else System.out.println("Remote machine");