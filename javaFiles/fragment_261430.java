@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ComponentScan(basePackages = {"com.my.package.example"})
@EnableAutoConfiguration
@ImportResource
public @interface MyMetaAnnotationExample {

    @AliasFor(annotation=ImportResource.class, attribute="value")
    String[] value() default {};
}