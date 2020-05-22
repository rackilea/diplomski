/** Provides MyRelevantData for TheFramework */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@MyAnnotation
public @interface MyEnumAnnotation {

    MyEnumType value(); // default MyEnumType.FOO;

}

@MyEnumAnnotation(MyEnum.FOO)
private MyEnumType myValue;