public static int size(Object object) {
    if (!object.getClass().isArray()) {
        return 1;
    }

    int size = 0;
    for (int i = 0; i < Array.getLength(object); i++) {
        size += size(Array.get(object, i));
    }
    return size;
}