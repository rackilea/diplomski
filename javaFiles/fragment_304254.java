public static String padd10(String str) {
    return Stream.generate(() -> "0")
            .limit(str.length() >= 10 ? 0 : 10 - str.length())
            .collect(Collectors.collectingAndThen(
              Collectors.joining(), str.substring(0, Math.min(str.length(), 10))::concat));
}