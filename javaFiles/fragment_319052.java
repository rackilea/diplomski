private static InetAddress thisIp;

static{
    try {
        thisIp  = InetAddress.getLocalHost();
    } catch (UnknownHostException ex) {

    }
}