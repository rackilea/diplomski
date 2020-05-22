@Component
public class SomeClass {

    @Value("#{environment.SOME_KEY_PROPERTY}")
    private String key;

    ....
}