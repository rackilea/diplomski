String initialString = "1234567890";
String firstPart = initialString;
while (metrics.stringWidth(firstPart) > MAX_WIDTH) {
    firstPart = firstPart.substring(0, firstPart.length() - 1);
}
String secondPart = initialString.substring(firstPart.length(), initialString.length());