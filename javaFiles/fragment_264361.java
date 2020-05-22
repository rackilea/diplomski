public StringBuilder rTrim(StringBuilder str, String trimStr) {
    if (str != null && trimStr != null) {
        int trimLen = trimStr.length();
        int strLen = str.length();
        if (strLen != 0 && trimLen != 0) {
            while (strLen != 0 && str.substring(strLen - trimLen, strLen).equals(trimStr)) {
                str = str.delete(strLen - trimLen, strLen);
                strLen = str.length();
            }
        }
    }
    return str;
}