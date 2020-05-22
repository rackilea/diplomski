public enum JDKVersion {
    JDK_11(45, 3, "JDK 1.1"), // "0x2D"
    JDK_12(46, 0, "JDK 1.2"), // "0x2E"
    JDK_13(47, 0, "JDK 1.3"), // "0x2F"
    JDK_14(48, 0, "JDK 1.4"), // "0x30"
    JDK_50(49, 0, "J2SE 5.0"),// "0x31"
    JDK_60(50, 0, "J2SE 6.0"),// "0x32"
    JDK_7 (51, 0, "J2SE 7"),  // "0x33"
    JDK_8 (52, 0, "J2SE 8"),  // "0x34"
    JDK_9 (53, 0, "J2SE 9");  // "0x35"

    private JDKVersion(int majorVersion, int minorVersion, String textValue) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.textValue = textValue;
    }

    private final int majorVersion;
    private final int minorVersion;
    private final String textValue;

    // getters omitted ...
}