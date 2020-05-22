Integer getIp(InetSocketAddress addr) {
    byte[] a = addr.getAddress().getAddress();
    return ((a[0] & 0xff) << 24) | ((a[1] & 0xff) << 16) | ((a[2] & 0xff) << 8) | (a[3] & 0xff);
}

public int compare(InetSocketAddress o1, InetSocketAddress o2) {
    //TODO deal with nulls
    if (o1 == o2) {
        return 0;
    } else if(o1.isUnresolved() || o2.isUnresolved()){
        return o1.toString().compareTo(o2.toString());
    } else {
        int compare = getIp(o1).compareTo(getIp(o2));
        if (compare == 0) {
            compare = Integer.valueOf(o1.getPort()).compareTo(o2.getPort());
        }
        return compare;
    }
}