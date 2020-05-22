public class A extends Controller {

    public Result create(String param) {
        ...
    }

}

public class B extends Controller {

    @Inject
    private A a;

    public Result create() {
        a.create("param");
        // do other stuff and return result
    }

}