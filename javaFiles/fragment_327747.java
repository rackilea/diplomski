public static Double parseInput(String input) {
    try {
        return input.equals("None") ? null : Double.valueOf(input);
    } catch (NumberFormatException | NullPointerException e) {
        return Double.NaN;
    }
}