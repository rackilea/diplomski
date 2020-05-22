Enumeration<NetworkInterface> tempNetInterface = null;
try {
    tempNetInterface = NetworkInterface.getNetworkInterfaces();
} catch (SocketException ex) {
    ex.printStackTrace();
}
ArrayList<NetworkInterface> interfaces = new ArrayList<>(Collections.list(tempNetInterface));