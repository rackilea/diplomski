class ClassIgnoranceIntrospector extends JacksonAnnotationIntrospector {

    private final Class<?> clazz;

    ClassIgnoranceIntrospector(Class<?> clazz) {
        this.clazz = clazz;
    }

    public boolean hasIgnoreMarker(AnnotatedMember m) {
        return m.getDeclaringClass() != clazz;
    }
}