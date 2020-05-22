private Integer[] generator() {
    int size = (int) (Math.random() * 100);
    Integer[] result = new Integer[size];

    for (int i = 0; i < result.length; i++) {
        result[i] = (int) (Math.random() * 50);

    }
    return result;
}