@Component
public class MyConfig {

    private final List<String> values;

    public MyConfig(@Value("${my-config.values}") List<String> values) {
        this.values = ImmutableList.copyOf(values);
    }
}