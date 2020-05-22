@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Localize {

    String value();

}