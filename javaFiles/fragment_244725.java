public static UUID fromString(String name) {
    String[] components = name.split("-");
    if (components.length != 5)
        throw new IllegalArgumentException("Invalid UUID string: "+name);
    for (int i=0; i<5; i++)
        components[i] = "0x"+components[i];

    long mostSigBits = Long.decode(components[0]).longValue();
    mostSigBits <<= 16;
    mostSigBits |= Long.decode(components[1]).longValue();
    mostSigBits <<= 16;
    mostSigBits |= Long.decode(components[2]).longValue();

    long leastSigBits = Long.decode(components[3]).longValue();
    leastSigBits <<= 48;
    leastSigBits |= Long.decode(components[4]).longValue();

    return new UUID(mostSigBits, leastSigBits);
}