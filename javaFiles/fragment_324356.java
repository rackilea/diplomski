MulticastSocket multicastSocket = new MulticastSocket("5678");
NetworkInterface wifiInterface = null;
for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces()))
    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
        wifiInterface = networkInterface;
        break;
        }

multicastSocket.setNetworkInterface(wifiInterface);