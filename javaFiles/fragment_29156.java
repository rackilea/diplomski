/**
 * @since 1.5
 */
public Annotation[] getAnnotations() { 
    return getDeclaredAnnotations();
}

/**
 * @since 1.5
 */
public Annotation[] getDeclaredAnnotations()  {
    throw new AssertionError("All subclasses should override this method");
}