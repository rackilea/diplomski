abstract class Foo{
    public Foo(){}

    public void checkable(){
        calledWhenCheckableIsCalled();            
        doCheckable();
    } 

    protected abstract void doCheckable();

    public void calledWhenCheckableIsCalled(){
        System.out.println("checkable was called");
    }
}