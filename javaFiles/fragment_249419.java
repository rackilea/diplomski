@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.TYPE)
@interface MyAnnotation {

    String foo ();
    String bar ();
}