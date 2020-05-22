@Component //import org.springframework.stereotype.Component;
public class MyCustomDozerConverter extends DozerConverter<MyObject, String> {

    private static AppConfig appConfig;

    // dozer needs this constructor to create an instance of converter (so it's a mandatory constructor)
    public MyCustomDozerConverter() {
        super(MyObject.class, String.class);
    }

    @Autowired // Spring will pass appConfig to constructor
    public MyCustomDozerConverter(AppConfig appConfig) {
        this();
        this.appConfig = appConfig;
    }

    @Override
    public String convertTo(MyObject source, String destination) {      
        String myProperty = appConfig.getWhatever();
        // business logic
        return destination;
    }

    @Override
    public MyObject convertFrom(String source, MyObject destination) {
        // business logic
        return null;
    }
}