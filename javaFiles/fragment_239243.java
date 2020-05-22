public static Collection<Method> methodWithAnnotation(Class<?> classType, Class<?  extends Annotation> annotationClass) {

  if(classType == null) throw new NullPointerException("classType must not be null");

  if(annotationClass== null) throw new NullPointerException("annotationClass must not be null");  

  Collection<Method> result = new ArrayList<Method>();
  for(Method method : classType.getMethods()) {
    if(method.isAnnotationPresent(annotationClass)) {
       result.add(method);
    }
  }
  return result;
}