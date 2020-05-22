class MyClass {
    public static void main(String[] args) {
        invoke(MyClass::someTask);
        invoke(MyClass::someTask1);
    }

    private static void someTask() throws Exception {
        System.out.println("Task 1");
    }

    private static void someTask1() throws Exception {
        throw new Exception("Exception");
    }
}