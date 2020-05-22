@Component // This will default give you a single ton bean
public class NodeMac {

    @Value("${machine.network.interface}")
    private String networkInterfaceName;

    public String getMacAddress() {
        try {
            NetworkInterface network = NetworkInterface.getByName(networkInterfaceName);

            byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        } catch (SocketException | NullPointerException e) {
            throw new RuntimeException(
                    "Failed to extract MAC address for network interface with name " + networkInterfaceName, e);
        }
    }
}