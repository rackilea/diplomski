@Component
public class SomeComponent {

    interface SomeInterface {

    }

    @Component
    static class Impl1 implements SomeInterface {

    }

    @Component
    static class Impl2 implements SomeInterface {

    }

    @Autowired
    private List<SomeInterface> listOfImpls;
}