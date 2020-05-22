public class SomeClass {
    public static final String myAttribute = "abc";
}

@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String[] value();
}

public class SomeOtherClass {
    @MyAnnotation({SomeClass.myAttribute})
    private int someInt;
}