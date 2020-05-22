class ReflectionTest {


    // Use either
    private final String value;
    {
        value = "test";
    }
    // Or 
    private final String value;
    public ReflectionTest () {
        value = "test";
    }
    // Or
    private final String value = Function.identity().apply("test");
    // Or

    //   Do not replace with + as the compiler is too smart
    private final String value = "test".concat(""); 
    // Depending on your required performance/codestyling analyses

    private String getValue() {
        return value;
    }

}