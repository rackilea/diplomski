@ObjectClassDefinition
public @interface MyConfig {

    // This defines the property key "myProp" with
    // a default value of "foo" and it will show
    // up in the UI with the name "My Prop"
    String myProp() default "foo";

    // This defines the property key "my.prop"
    // with a default value of 42. The @AD
    // allows customisation of the UI
    @AD(description="Something descriptive")
    int my_num() default 42;
}