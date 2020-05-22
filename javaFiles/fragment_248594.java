class Bar {
private static class ArrayHolder {
    public static List<String> array = new ArrayList<>();
}

public static Bar getArray() {
    return array;
}
}