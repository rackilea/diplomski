public static boolean contains(Object[] array, Object item) {
    if (array == null || item == null) {
        return false;
    }

    for (Object object : array) {
        if (object != null && object.toString().equals(item.toString())) {
            return true;
        }
    }

    return false;
}