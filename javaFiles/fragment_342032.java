public static void main(String[] args) {
    Object array = new String[][] {new String[] {"a", "b"}, new String[] {"c", "d"}};
    processArray(array, System.out::println);
}

public static void processArray(Object object, Consumer<Object> processor) {
    if (object != null && object.getClass().isArray()) {
        int length = Array.getLength(object);
        for (int i = 0; i < length; i ++) {
            Object arrayElement = Array.get(object, i);
            processArray(arrayElement, processor);
        }
    } else {
        processor.accept(object);
    }
}