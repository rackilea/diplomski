@Service
class MyService{
    private final FooFactory fooFactory;

    @Autowired
    public MyService(FooFactory fooFactory){
        this.fooFactory = fooFactory;
    }

    public void doSomething(){
        // can of course be generated with a normal for loop too
        List<Foo> foos = IntStream.range(0, 10)
            .mapToObj(i -> fooFactory.create())
            .collect(Collectors.toList());

        // do something with 10 foo instances   
    }
}