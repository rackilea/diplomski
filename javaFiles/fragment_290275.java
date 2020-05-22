public static <T> List<List<T>> foo(List<List<T>> parameter) {
    //do something
}

public void test() {
    List<List<Integer>> parameter;
    //do something with the parameter
    List<List<Integer>> product = foo(parameter);
}