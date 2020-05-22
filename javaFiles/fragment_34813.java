boolean isTemperature(String check) {
    char[] letters = check.toCharArray();
    if (check.indexOf("°").equals((letters.length - 1)) {
        return true;
    }
    return false;
}