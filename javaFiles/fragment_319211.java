public void printArray(Object[] array) {
    System.out.print('[');
    boolean first = true;
    for (Object obj : array) {
        if (!first) {
            System.out.print(", ");
        } else {
            first = false;
        }
        System.out.print(String.valueOf(obj));
    }
    System.out.print(']');
}