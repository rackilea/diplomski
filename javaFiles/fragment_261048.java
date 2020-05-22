public static void main(String[] args) throws Exception {
    System.out.println(toSciNotation(1000123.456));         // would become 1.00E6 
    System.out.println(toSciNotation(-1123123.456));        // would become 1.1E-6 
    System.out.println(toSciNotation(1.2345678));           // would become 1.2345 
    System.out.println(toSciNotation(1000000000000L));      // would become 1.0E12
    System.out.println(toSciNotation(0.0000012345));        // would become 1.2E-6
    System.out.println(toSciNotation(0.0000000012345));     // would become 1.2E-9
    System.out.println(toSciNotation(12.12345E12));         // would become 1.2E13
}

private static String toSciNotation(double number) {
    return formatSciNotation(new DecimalFormat("0.00E0").format(number));
}

private static String toSciNotation(long number) {
    return formatSciNotation(new DecimalFormat("0.00E0").format(number));
}

private static String formatSciNotation(String strNumber) {
    if (strNumber.length() > 6) {
        Matcher matcher = Pattern.compile("(-?\\d+)(\\.\\d{2})(E-?\\d+)").matcher(strNumber);

        if (matcher.matches()) {
            int diff = strNumber.length() - 6;
            strNumber = String.format("%s%s%s", 
                    matcher.group(1),
                    // We add one back to include the decimal point
                    matcher.group(2).substring(0, diff + 1),
                    matcher.group(3)); 
        }
    }
    return strNumber;
}