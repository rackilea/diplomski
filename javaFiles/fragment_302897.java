@Component("classa")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClassA implements InterB {
    private static int counter=0;

    private int objectid = 0;
    @Autowired
    InterA abcd;

    public ClassA() {
        super();
        this.objectid = ++counter;
    }

    @Override
    public void dododo() {
        System.out.println("instance number "+objectid++);
        abcd.doit();
    }
}