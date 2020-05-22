private static final Pattern leadingZeroPattern = Pattern.compile("^0+");
private static final String EMPTY_STRING = "";

public static void main(String[] args) {
    String x = "-232330000809";
    String xWithoutZeros = leadingZeroPattern.matcher(x).replaceFirst(EMPTY_STRING);
    System.out.println(Long.parseLong(xWithoutZeros));
}