// RequiresConversion is a custom annotation solely used in this example
// to annotate an attribute as "convertable"
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresConversion {
}