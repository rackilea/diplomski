int length = s.length();

if (length <= 1) {
    return s;
} else {
    return s.charAt(length - 1) + s.substring(1, length - 1) + s.charAt(0);
}