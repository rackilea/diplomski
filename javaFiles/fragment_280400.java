//Interface
public interface ICallback{
    void onMessage(String msg);
}

//the class A call methods from B
public class A implements ICallback{

    private B b;

    public A(){
        b= new B();
        b.setCallback(this);
        b.printSomething(5);
        b.printSomething(0);
    }
    @Override
    public void onMessage(String msg){
    }
}

//the Class B can communicate to A with the callback
public class B {
    private ICallback cb;
    public B(){
    }
    public void setCallback(ICallback cb){
        this.cb = cb;
    }
    public void printSomething(int i){
        if(i==0){
            cb.onMessage("this is zero");
        }
    }
}