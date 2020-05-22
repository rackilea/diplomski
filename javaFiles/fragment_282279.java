@Target({}) @Retention(RUNTIME)
public @interface Index {
 String name() default "";
 String columnList();
 boolean unique() default false;
}