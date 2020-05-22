createArray(); // no exception
String[] arr = createArray(); // causes ClassCastException

public static <E> E[] createArray() {
    return (E[]) new Object[1];
}