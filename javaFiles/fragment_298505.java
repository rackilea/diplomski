public static <A> A doubleArray(A array) {
    int length = Array.getLength(array);
    Class<?> componentType = array.getClass().getComponentType();
    A copy = (A) Array.newInstance(componentType, length * 2);
    System.arraycopy(array, 0, copy, 0, length);
    return copy;
}