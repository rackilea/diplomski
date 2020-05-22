public static List<? extends List<? extends Object>> foo(List<? extends List<? extends Object>> parameter) {
    //do something
}

public void test() {
    List<List<Integer>> parameter = new ArrayList<>();
    //do something with the parameter
    foo(parameter);
}