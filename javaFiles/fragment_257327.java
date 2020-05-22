InetAddress ip = InetAddress.getLocalHost();
System.out.println("Current IP address : " + ip.getHostAddress());

NetworkInterface network = NetworkInterface.getByInetAddress(ip);

byte[] mac = network.getHardwareAddress();

System.out.print("Current MAC address : ");

StringBuilder sb = new StringBuilder();
for (int i = 0; i < mac.length; i++) {
    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
}
System.out.println(sb.toString());