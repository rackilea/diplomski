static String returnMacAddress(){             // 1.
    InetAddress ip;
    try{                                      // 2.
        ip = InetAddress.getLocalHost();      // 3. (until return stmt)

        NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        byte[] mac = network.getHardwareAddress();

        System.out.print("Current MAC address: ");

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < mac.length; i++){
            stringBuilder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        return stringBuilder.toString();       // 4.
    }catch(UnknownHostException e){            // 5.
        e.printStackTrace();                   // 6.
    } catch(SocketException e){
        e.printStackTrace();
    }
    return null;                               // 7.
}