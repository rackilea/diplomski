@Component(name="test")
public class MyFoo {
    private List<External> externals; //injected
    private Bar bar; //passed via constructor. Bar is *not* a @Component

    public MyFoo(@Property(name = "somebar") Bar otherBar) {
        bar = otherBar;
        externals = new ArrayList();
    }

    @Bind(aggregate=true)
    public addExternal(External service) {
        externals.add(service);
    }
}