public class MyClass extends SomeOtherClass {

    @Autowired
    private OtherClass1 one;

    @Autowired
    private OtherClass2 two

    public MyClass(){
        super(one, two)
    }
}