@Named
public class MyObjectFactory {
    @Inject
    private MyOtherObject otherObject;

    public MyObject newInstance() {
        return new MyObject(otherObject);
    }
}