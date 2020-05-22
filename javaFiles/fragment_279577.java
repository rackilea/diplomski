public static Enumeration<NetworkInterface> getNetworkInterfaces()
    throws SocketException {
    final NetworkInterface[] netifs = getAll();

    // specified to return null if no network interfaces
    if (netifs == null)
        return null;

    return new Enumeration<NetworkInterface>() {              // This is the
        private int i = 0;                                    // anonymous
        public NetworkInterface nextElement() {               // inner class used
            if (netifs != null && i < netifs.length) {        // to implement
                NetworkInterface netif = netifs[i++];         // Enumeration<NetworkInterface>
                return netif;                                 //
            } else {                                          //
                throw new NoSuchElementException();           //
            }                                                 //
        }                                                     //
                                                              //
        public boolean hasMoreElements() {                    //
            return (netifs != null && i < netifs.length);     //
        }                                                     //
    };                                                        //
}