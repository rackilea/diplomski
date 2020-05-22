public class LocalizedExceptionTransformer implements IAnnotationTransformer {
  public void transform(ITest annotation, Class testClass,
      Constructor testConstructor, Method testMethod) {
    if (testMethod != null) {
      LocalizedException le = testMethod.getAnnotation(LocalizedException.class);
      if (le != null) {
         String regexp = regexize(le);
         annotation.setExpectedExceptionsMessageRegExp(regexp);
      }
    }
  }
}