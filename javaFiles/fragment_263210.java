@Retention(RetentionPolicy.RUNTIME)
@interface SomeInfo {
    String author();
    int year() default -1;
    String column() default "";
    String somethingElse() default "";
}

class Main {
    public static void main(String[] args) throws Exception {
        List<AnnotatedElement> annotatedElements =
            new ArrayList<AnnotatedElement>();
        annotatedElements.add(Foo.class);
        annotatedElements.add(Foo.class.getDeclaredField("x"));
        annotatedElements.add(Foo.class.getDeclaredMethod("getX"));
        for (AnnotatedElement annotatedElement : annotatedElements) {
            System.out.println("Author of {" + annotatedElement + "} = " +
                annotatedElement.getAnnotation(SomeInfo.class).author());
        }
    }
}