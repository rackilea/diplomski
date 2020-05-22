public static double toSeconds(final String unit, final double value) {
    switch (unit.toLowerCase()) {
    case "d":
    case "day":
        return NonSI.DAY.getConverterTo(SI.SECOND).convert(value);
    case "m":
    case "minute":
        return NonSI.MINUTE.getConverterTo(SI.SECOND).convert(value);
    case "s":
    case "second":
        return value;
    default:
        throw new IllegalArgumentException(unit);
    }
}