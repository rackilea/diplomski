public abstract class MyClass {

    private MyService myService;

    public void setMyService(MyService myService) {
        this.myService = myService;
    }
}

@Component
public class MyClass1 extends MyClass {
    @Autowired @Qualifier("myService1")
    @Override
    public void setMyService(MyService myService) {
        super.setMyService(myService);
    }
}

@Component
public class MyClass2 extends MyClass {

    @Autowired @Qualifier("myService2")
    @Override
    public void setMyService(MyService myService) {
        super.setMyService(myService);
    }
}