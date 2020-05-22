public static void main(String[] args) {
    String stringToCenter = "blablah";
    int lineLength = 51;
    int stringLength = stringToCenter.length();

    int missingSpaces = lineLength - stringLength;
    int paddingBefore = missingSpaces / 2;
    int paddingAfter = missingSpaces - paddingBefore;

    // TODO: write code to print "paddingBefore" spaces

    System.out.print(stringToCenter);

    // TODO: write code to print "paddingAfter" spaces

}