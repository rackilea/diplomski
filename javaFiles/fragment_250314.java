public interface B extends A {
    @Override
    public default void doSomething(){
        System.out.println("B");

        BHelper.other(this);
    }
    default public void other(){
        BHelper.other(this);
    }
}