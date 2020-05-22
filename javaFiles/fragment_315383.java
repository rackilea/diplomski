@Component
public class MyClass implements EntryAddedListener<String, MyEntry> {

    private final Executor executor;
    private final ClassToBeCalled classToBeCalled;

    @Autowired
    public MyClass(@Qualifier("asyncExecutor") Executor executor, ClassToBeCalled classToBeCalled) {
        this.executor=executor;
        this.classToBeCalled=classToBeCalled;
    }
}