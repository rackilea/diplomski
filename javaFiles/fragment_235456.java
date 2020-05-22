try {
  for (Map.Entry<String, Object> attr : tagAttrs.entrySet()) {
    String attrd = String.format("%s='%s'", attr.getKey(), attr
        .getValue().toString());
    pageContext.getOut().print(attrd);
  }
} catch (IOException e) {
  throw new JspException(e);
}