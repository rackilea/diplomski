boolean isPercentual(String check) {
    try {
        double verify = Double.parseDouble(check);
    } catch (NumberFormatException e) {
        return false;
    }
    char[] numbers = check.toCharArray();
    if (check.indexOf("%").equals(numbers.length) {
        return true;
    }
    return false;
}