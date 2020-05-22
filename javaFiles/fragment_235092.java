if (ofArray.isPrimitive()) {
    int length = Array.getLength(o);
    for (int i = 0; i < length; i++) {
        Object obj = Array.get(o, i);
        System.out.println(obj);
    }
}
else {
    Object[] objects = (Object[]) o;
    for (Object obj : objects) {
        System.out.println(obj);
    }
}