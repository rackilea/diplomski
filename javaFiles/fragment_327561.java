public class SomeClassDeserializer extends StdDeserializer<SomeObject> {
    private static SomeUtil someUtil;

    public SomeClassDeserializer(Class<?> vc) {
        super(vc);
    }

    public SomeClassDeserializer() {
        this(null);
    }

    @Autowired
    public SomeClassDeserializer(SomeUtil someUtil) {
        this(null);
        SomeClassDeserializer.someUtil= someUtil;
    }