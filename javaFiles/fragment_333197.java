public static boolean isEmpty(final Object o) {
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

    // reflection code

    final Number length = retrieveNumberFromMethod(o, "length");
    if (length != null) {
        return length.shortValue() <= 0;
    }

    final Number size = retrieveNumberFromMethod(o, "size");
    if (size != null) {
        return size.shortValue() <= 0;
    }

    final Boolean isEmpty = retrieveBooleanFromMethod(o, "isEmpty");
    if (isEmpty != null) {
        return isEmpty;
    }

    return false;
}

static Number retrieveNumberFromMethod(final Object o, final String methodName) {
    try {
        final Number number = (Number) o.getClass().getMethod(methodName).invoke(o);
        return number;
    }
    catch (final IllegalArgumentException e) {
        throw new IllegalStateException("Unable to retrieve number from " + methodName + " on " + o, e);
    }
    catch (final SecurityException e) {
        throw new IllegalStateException("Unable to retrieve number from " + methodName + " on " + o, e);
    }
    catch (final InvocationTargetException e) {
        throw new IllegalStateException("Unable to retrieve number from " + methodName + " on " + o, e);
    }
    catch (final IllegalAccessException e) {
        return null;
    }
    catch (final NoSuchMethodException e) {
        return null;
    }
}

static Boolean retrieveBooleanFromMethod(final Object o, final String methodName) {
    try {
        final Boolean bool = (Boolean) o.getClass().getMethod(methodName).invoke(o);
        return bool;
    }
    catch (final IllegalArgumentException e) {
        throw new IllegalStateException("Unable to retrieve boolean from " + methodName + " on " + o, e);
    }
    catch (final SecurityException e) {
        throw new IllegalStateException("Unable to retrieve boolean from " + methodName + " on " + o, e);
    }
    catch (final InvocationTargetException e) {
        throw new IllegalStateException("Unable to retrieve boolean from " + methodName + " on " + o, e);
    }
    catch (final IllegalAccessException e) {
        return null;
    }
    catch (final NoSuchMethodException e) {
        return null;
    }
}