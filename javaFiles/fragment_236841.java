@Indexed(background = true) // fix attribute values here
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
public @interface ComposedIndexedAnnotation {

    @AliasFor(annotation = Indexed.class, attribute = "unique")
    boolean unique() default false;

    @AliasFor(annotation = Indexed.class, attribute = "name")
    String indexName() default "";
}