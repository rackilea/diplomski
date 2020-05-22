// java.lang.String
public static String valueOf(double d) {
    return Double.toString(d);
}

// java.lang.Double
public static String toString(double d) {
    return new FloatingDecimal(d).toJavaFormatString();
}