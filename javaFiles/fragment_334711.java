private static Class<?>[] toPrimitiveTypeArray(
//      vvvvvvvv
        Class<?>[] objects, boolean log) {
    ...

    for (int i = 0; i < types.length; i++) {
        ...
        //                          vvvvvvvvvv
        types[i] = getPrimitiveType(objects[i]);
    }
    ...
}