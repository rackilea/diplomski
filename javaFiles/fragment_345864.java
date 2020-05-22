MyObject(String sn) {
    if (sn == null || sn.length() < 7 || sn.length() > 9) {
        throw new IllegalArgumentException("sn");
    }
    serialNumber = sn;
}