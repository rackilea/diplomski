@Component("classc")
public class ClassC {

    @Autowired
    Provider<InterB> classAPrototypeobj;

    public void doFromAbove() {
        //you can do a for loop here and get a set of objects for use
        InterB cls = (InterB) classAPrototypeobj.get();
        InterB cls1 = (InterB) classAPrototypeobj.get();
        cls.dododo();
        cls1.dododo();
        System.out.println(cls);
        System.out.println(cls1);
    }
}