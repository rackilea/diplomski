if (array.getClass().isArray()) {
    int length = Array.getLength(array);
    for (int i = 0; i < length; i ++) {
        Object arrayElement = Array.get(array, i);
        System.out.println(arrayElement);
    }
}