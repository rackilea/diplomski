@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface a{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface b{}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface Mark{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Mark
public @interface c{}

public static class D {
    @a @b @c
    public void x() {}
}

public static void main(String[] args) throws Exception {
    Method m = D.class.getMethod("x");

    Collection<Annotation> ret = new HashSet<Annotation>();
    Annotation[] annotations = m.getAnnotations();
    for (Annotation annotation : annotations) {
        Annotation subAnnots = annotation.annotationType().getAnnotation(Mark.class);
        if (subAnnots != null) {
            ret.add(annotation);
        }
    }
    System.out.println(ret);
}