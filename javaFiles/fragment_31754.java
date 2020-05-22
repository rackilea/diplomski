private static Map<String, Integer> bannedAddresses = new HashMap<String, Integer>();
...
public static boolean checkIfAddressBanned(InetSocketAddress from) {
    String address = from.getAddress().getHostAddress();
    Integer attempts = bannedAddresses.get(address);
    if (attempts == null) return false;
    bannedAddresses.put(address, attempts+1);
    if ( (loggingEnabled) && (attempts % 50 == 1) ) {
        log.info(String.format("IP [%s] is banned, %d attempts", address, attempts));
    }
    return true;
}