boolean isYear(String check) {
    try {
        int verify = Integer.parseInt(check);
    } catch (NumberFormatException e) {
        return false;
    }
    char[] verify2 = check.toCharArray();
    if ((verify2.length).equals(4)) {
        return true;
    }
    return false;
}