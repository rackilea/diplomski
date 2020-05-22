public List<Field> getAllFields(Form form) {
  Collection<?> propertyIds = form.getItemPropertyIds();
  List<Field> fields = new ArrayList<Field>(propertyIds.size());
  for (Object itemPropertyId : propertyIds) {
    fields.add(form.getField(itemPropertyId));
  }
  return fields;
}