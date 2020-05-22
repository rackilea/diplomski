if (field.getType().isArray()) { // <-- should be getType(), thx @Pshemo
    Object array = field.get(obj);
    int len = Array.getLength(array);
    for (int i = 0; i < len; i++) {
        Object v = Array.get(array, i);
        System.out.println(v);
    }
} // ...