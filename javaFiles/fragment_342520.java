@Singleton
public class MyOtherClassWrapper {

    private MyOtherClass myOtherClass = new MyOtherClass();

    public String decodeAndGetName() {
        return getMyOtherClass().decodeAndGetName();
    }

    ...

    private MyOtherClass getMyOtherClass() {
        return myOtherClass;
    }

}