public static boolean isEmpty(Object o) {
    if (o == null) {
        return true;
    }
    else if (o instanceof Object[]) {
        return ((Object[]) o).length <= 0;
    }
    else if (o instanceof boolean[]) {
        return ((boolean[]) o).length <= 0;
    }
    else if (o instanceof byte[]) {
        return ((byte[]) o).length <= 0;
    }
    else if (o instanceof short[]) {
        return ((short[]) o).length <= 0;
    }
    else if (o instanceof char[]) {
        return ((char[]) o).length <= 0;
    }
    else if (o instanceof int[]) {
        return ((int[]) o).length <= 0;
    }
    else if (o instanceof long[]) {
        return ((long[]) o).length <= 0;
    }
    else if (o instanceof float[]) {
        return ((float[]) o).length <= 0;
    }
    else if (o instanceof double[]) {
        return ((double[]) o).length <= 0;
    }
    else if (o instanceof CharSequence) {
        return ((CharSequence) o).length() <= 0;
    }
    else if (o instanceof Collection) {
        return ((Collection) o).isEmpty();
    }
    else if (o instanceof Map) {
        return ((Map) o).isEmpty();
    }
    else if (o instanceof Enumeration) {
        return !((Enumeration) o).hasMoreElements();
    }
    else if (o instanceof Dictionary) {
        return ((Dictionary) o).isEmpty();
    }
    else if (o instanceof Iterable) {
        // NOTE: may not be efficient because an iterator is created
        return !((Iterable) o).iterator().hasNext();
    }

  return false;
}