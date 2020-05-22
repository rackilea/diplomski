public enum Resolution {

    RES_32(32),
    RES_64(64),
    RES_128(128),
    RES_256(256);

    public static Set<Resolution> deluxe = EnumSet.allOf(Resolution.class);
    public static Set<Resolution> typical = EnumSet.range(RES_64, RES_128);
    public static Set<Resolution> ecomomy = EnumSet.of(RES_32);

    private final int asInt;

    private Resolution(int asInt) {
        this.asInt = asInt;
    }
};