public interface B extends A {
    @Override
    public default void doSomething(){
        System.out.println("B");

        otherInB();
    }
    default public void other(){
        otherInB();
    }
    static void otherInB() {
        //doSomething();
        System.out.println("other");
    }
}