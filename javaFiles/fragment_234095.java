@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {
    String command();
    String name();
    String desc() default "";
    String[] aliases() default {};
    boolean admin() default true;
}