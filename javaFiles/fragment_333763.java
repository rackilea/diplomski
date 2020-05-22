public static <T> int findFirstNull(List<T> al) {
    for (int i = 0, len = al.size(); i < len; i++) {
        if (al.get(i) == null) {
            return i;
        }
    }
    return -1;
}