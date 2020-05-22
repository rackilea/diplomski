private void appendAttribute(final String attributeName, 
  final String attributeValue, final StringBuilder builder) {

  if(attributeValue != null) {
      builder.append(attributeName);
      builder.append(EQUALS_CHAR);
      builder.append(attributeValue);
      builder.append(AMPERSAND_CHAR);
  }
}