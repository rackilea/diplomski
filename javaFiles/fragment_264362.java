public StringBuilder lTrim(StringBuilder str, String trimStr) {
    if (str != null && trimStr != null) {
        int len = trimStr.length();
        if (str.length() != 0 && len != 0) {
            while (str.length() != 0 && str.substring(0, len).equals(trimStr)) {
                str = str.delete(0, len);
            }
        }
    }
    return str;
}