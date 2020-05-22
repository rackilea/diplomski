public static String value;

@Value("${value}")
public void setValue(String someValue) {
    SomeClass.value = someValue;
}