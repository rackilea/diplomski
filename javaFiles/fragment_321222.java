ElementType[] target = new MyWork<>(MyAnnotation.class).checkAnnotationElementType();
class MyWork<T extends Annotation> {

    private final Class<T> annotationClass;

    public MyWork(Class<T> annotationClass) {
        this.annotationClass = annotationClass;
    }

    public ElementType[] checkAnnotationElementType() {
        return annotationClass.getAnnotation(Target.class).value();
    }
}