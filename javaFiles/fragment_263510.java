public static void popOffLastElement(List<?> list) {
    if (list.size() > 0) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}