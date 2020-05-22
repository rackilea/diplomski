public static enum EncodingType {
    PLAIN(1), GZIP(2);

    private int numVal;

    EncodingType(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }

    public static EncodingType fromInteger(int x) {
        switch (x) {
            case 1:
                return PLAIN;
            case 2:
                return GZIP;
            default:
                return PLAIN;
        }
    }
}