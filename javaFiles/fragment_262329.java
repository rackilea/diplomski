int intValue;
try {
    intValue = Integer.parseInt(hex, 16);
} catch (NumberFormatException e) {
    intValue = 0;
}