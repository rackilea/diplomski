public boolean isDecimal(String str) {
    try {
        Double.parseDouble(str);
    }
    catch(NumberFormatException ex) {
        return false;
    }
    return true;
}