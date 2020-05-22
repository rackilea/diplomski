public static <T> void popOffLastElement(List<T> list) {
    if (list.size() > 0) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}