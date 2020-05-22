public static void main(String [] args) {
    LocalTime start = parseHelper("20:28");
    LocalTime stop = parseHelper("20:18");
    Duration duration = Duration.between(start, stop);
    System.out.println(duration.getSeconds());
}

private static LocalTime parseHelper(String str) {
    return LocalTime.parse("00:" + str);
}