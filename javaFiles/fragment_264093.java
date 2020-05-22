public static String toString(char[] buf) {
    int len = buf.length;
    for (int index = 0; index < len; index++) {
        if (buf[index] == '\0') {
            len = index;
            break;
        }
    }

    if (len == 0) {
        return "";
    } else {
        return new String(buf, 0, len);
    }
}