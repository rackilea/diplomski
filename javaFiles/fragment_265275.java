public int countHi2(String str) {
    if (str == null || str.length() < 2)
        return 0;
    if (str.startsWith("hi"))
        return 1 + countHi2(str.substring(2));
    return countHi2(str.substring(str.startsWith("xhi") ? 3 : 1));
}