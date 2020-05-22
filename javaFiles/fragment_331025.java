private static void digest(String formatTxt) {
    System.out.println("Doing: " + formatTxt);
    Pattern numPattern = Pattern.compile("(\\\\)(\\d+)(#*)");
    Matcher m = numPattern.matcher(formatTxt);
    if (m.matches()) {
        System.out.println("Pattern matched!");
        System.out.println("1. " + m.group(1));
        System.out.println("2. " + m.group(2));
        System.out.println("3. " + m.group(3));
        System.out.println("");
    }
}