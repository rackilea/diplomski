public interface B extends A {
    @Override
    public default void doSomething(){
        System.out.println("B");

        BHelper.other();
    }
    default public void other(){
        BHelper.other();
    }
}