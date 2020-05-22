for (int i = 0; i < fields.size(); i++) {
    String field = fields.get(i);
    String setter = setters.get(i);
    String updatedMethodName = methodName.get(i);
    String updatedFieldNames = updatedFieldName.get(i);
    creatingMethod(updatedMethodName, updatedFieldNames, field, setter);
}