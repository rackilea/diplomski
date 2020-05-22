public int strDist(String str, String sub) {
    if (sub.isEmpty()) {
        throw new IllegalArgumentException("sub mustn’t be empty");
    }
    if (str.length() <= sub.length()) {
        if (str.equals(sub)) {
            return str.length();
        } else { // sub cannot be in str
            return 0;
        }
    }
    if (str.startsWith(sub)) {
        if (str.endsWith(sub)) {
            return str.length();
        } else {
            return strDist(str.substring(0, str.length() - 1), sub);
        }
    } else {
        return strDist(str.substring(1), sub);
    }
}