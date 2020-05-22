@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SubTab {
    String name();
    String[] Fields() default {};
    SubView SubView() default @SubView(Listing={}, EntityType=Object.class);
}