public static String paddedBinaryFromLong( long val ) {
    StringBuilder sb = new StringBuilder( Long.toBinaryString(val));
    char[] zeros = new char[Long.SIZE - sb.length()];
    Arrays.fill(zeros, '0');
    sb.insert(0, zeros);
    return sb.toString();
}