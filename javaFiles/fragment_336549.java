public class MacAdd {

    public static void main(String[] args) {
        try {

            InetAddress add = InetAddress.getByName("192.168.46.53");


            NetworkInterface ni1 = NetworkInterface.getByInetAddress(add);
            if (ni != null) {
                byte[] mac1 = ni1.getHardwareAddress();
                if (mac1 != null) {

                    for (int k = 0; k < mac.length; k++) {
                        System.out.format("%02X%s", mac[k], (i < mac.length - 1) ? "-" : "");
                    }
                } else {
                    System.out.println("Address doesn't exist ");
                }
            } else {
                System.out.println("address is not found.");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}