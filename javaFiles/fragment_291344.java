class MyClass {

    private static int counter;

    public MyClass() {
        //...
        counter++;
    }

    public static int getNumOfInstances() {
        return counter;
    }
}