public static Map<Class<?>, List<Field>> getFieldsByType(Field[] fields) {
  Map<Class<?>, List<Field>> result = new HashMap<Class<?>, List<Field>>();
  for (Field field:fields) {
    List<Field> fieldList = result.get(field.getType());
    if (fieldList == null) {
      fieldList = new ArrayList<Field>();
      result.put(field.getType(), fieldList);
    }
    fieldList.add(field);
  }
  return result;
}