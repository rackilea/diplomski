public static void main(String[] args) {
    String input = "123456";
    Double minutes = parseDouble(input.substring(0, 2));
    Double seconds = parseDouble(input.substring(2, 4));
    Double hours = parseDouble(input.substring(4, 6));
    System.out.printf("Hours %.0f Minutes %.0f Seconds %.0f\n", hours, minutes, seconds);
}