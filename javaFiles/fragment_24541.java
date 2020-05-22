public class InputReplacementImpl implmements Input{

    private Input delegate;

    //setup delegate....

    public void foo(){
        System.out.println("foo replacement");
    }
    public void bar(){
        delegate.bar();
    }
}