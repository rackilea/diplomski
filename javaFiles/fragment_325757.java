class CannotModify{
    public void doSomething(){}
}




public interface AddThisIfYouWant{
    public void doSomething();
}




public class Wrap extends CannotModify, implements AddThisIfYouWant{
    private final CannotModify yourInstance;

    public Wrap(){
        this.yourInstance=new CannotModify();
    }

    @Override
    public void doSomething(){
        super.doSomething();
    }

}