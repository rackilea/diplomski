public static void doSomething(Object... objs) {
    for (Object obj : objs) {
        System.out.println(obj);
    }
}

public static void main(String[] args) {
    int[] intArray = {1, 2, 3};
    doSomething(intArray);
}