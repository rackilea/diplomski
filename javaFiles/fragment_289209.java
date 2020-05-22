public void save() {
  List<Method> toSaveRecords = findMethodsAnnotatedWith(AlsoSaveRecord.class, obj);
  for (Method rec : toSaveRecords) {
    AlsoSaveRecord anno = rec.getAnnotation(AlsoSaveRecord.class);
    Class<?> recordType = anno.value();
    Object objToSave = rec.invoke(obj);
  }
}

List<Method> findMethodsAnnotatedWith(Class<? extends Annotation> annotation, Object instance) 
{
  Method[] methods = instance.getClass().getDeclaredMethods();
  List<Method> result = new ArrayList<Method>();
  for (Method m : methods) {
    if (m.isAnnotationPresent(annotation)) {
      result.add(m);
    }
  }
  return result;
}