public class CheckInnerStatic {

    private static class Test {
    static {
        System.out.println("Static block initialized");
    }
    public Test () {
        System.out.println("Constructor called");
    }
}

    public static void main (String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Inside main");
        Class<?> cls = Class.forName("CheckInnerStatic$Test");
        //Test test = new Test();
    }
}