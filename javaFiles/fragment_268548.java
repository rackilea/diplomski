public void loopFTP(String startIP, String endIP, int timeout) throws SocketException, IOException {
    InetAddress startAsIP = InetAddresses.forString(startIP);
    InetAddress endAsIP = InetAddresses.forString(endIP);
    while(true){

        System.out.println(startAsIP);
        attemptConnection(startAsIP, timeout);

        if(InetAddresses.coerceToInteger(startAsIP) <= InetAddresses.coerceToInteger(endAsIP))
            startAsIP = InetAddresses.increment(startAsIP);
        else
            startAsIP = InetAddresses.forString(startIP);


    }
}