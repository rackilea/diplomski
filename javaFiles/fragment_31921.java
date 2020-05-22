public class MyCustomDozerConverter extends DozerConverter<MyObject, String> {

    private static AppConfig appConfig;

    public MyCustomDozerConverter() {
        super(MyObject.class, String.class);
        appConfig = AppConfig.getInstance(); // Here are we intializing it by calling the static method we created.
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