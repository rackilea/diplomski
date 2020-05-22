List<Field> permissionFields = new ArrayList<Field>();
Field[] fields = Manifest.permission.class.getDeclaredFields();
for (Field declField : fields) {
  if ((declField.getType() == String.class) && Modifier.isFinal(declField.getModifiers())) {
    permissionFields.add(declField);
  }
}