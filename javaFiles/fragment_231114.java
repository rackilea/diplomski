for (NetworkInterface iNet : interfaces) {
    try {
        if (iNet.getHardwareAddress() != null) { //This verification might not be enought to find if a Interface is real.
            realInterfaces.add(iNet);
        }
    } catch (SocketException ex) {
        //TODO handle exception
    }
}