try {
    try {
        sig = constPool.getUTF8At(typeIndex);
        annotationClass = (Class<? extends Annotation>)parseSig(sig, container);
    } catch (IllegalArgumentException ex) {
        // support obsolete early jsr175 format class files
        annotationClass = (Class<? extends Annotation>)constPool.getClassAt(typeIndex);
    }
} catch (NoClassDefFoundError e) {
    if (exceptionOnMissingAnnotationClass)
        // note: at this point sig is "[unknown]" or VM-style
        // name instead of a binary name
        throw new TypeNotPresentException(sig, e);
    skipAnnotation(buf, false);
    return null;
}