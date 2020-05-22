private synchronized  Map<Class<? extends Annotation>, Annotation> declaredAnnotations() {
    if (declaredAnnotations == null) {
        declaredAnnotations = AnnotationParser.parseAnnotations(
            annotations, sun.misc.SharedSecrets.getJavaLangAccess().
            getConstantPool(getDeclaringClass()),
            getDeclaringClass());
    }
    return declaredAnnotations;
}