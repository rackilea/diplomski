protected class NestedField implements Field {

private String name;
private List<Field> fields;

public NestedField(String name, List<Field> fields) {
  this.name = name;
  this.fields = fields;
}

public List<Field> getFields() {
  return fields;
}

@Override
public String getName() {
  return name;
}

private String escapeSystemVariables(String fieldTarget) {
  if (fieldTarget.startsWith("_id")) {
    return StringUtils.prependIfMissing(fieldTarget, "$");
  } else {
    return fieldTarget;
  }
}

private String encloseStringInQuotations(String quotable) {
  return JSON.serialize(quotable);
}

private String buildSingleFieldTarget(Field field) {
  if (field instanceof NestedField) {
    return String.join(":", encloseStringInQuotations(field.getName()), field.getTarget());
  }
  return String.join(":", encloseStringInQuotations(field.getName()), encloseStringInQuotations(escapeSystemVariables(
    field.getTarget())));
}

private String buildFieldTargetList(List<Field> fields) {
  List<String> fieldStrings = new ArrayList<>();
  fields.forEach(field -> {
    fieldStrings.add(buildSingleFieldTarget(field));
  });
  return Joiner.on(",").skipNulls().join(fieldStrings);
}

@Override
public String getTarget() {
  // TODO Auto-generated method stub
  return String.format("{%s}", buildFieldTargetList(fields));
}


@Override
public boolean isAliased() {
  return true;
}