public static void main(String[] args) throws IOException {

    InetAddress ip = getExternalIp();

    if (!isIpBoundToNetworkInterface(ip))
        throw new IOException("Could not find external ip");

    System.out.println(ip);
}