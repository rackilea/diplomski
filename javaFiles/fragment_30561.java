public Map<String, MetaAttribute> tableToMetaAttributes(TableIdentifier tableIdentifier) {

  Map<String, MetaAttribute> metaAttributes = super.tableToMetaAttributes(tableIdentifier);

  if(metaAttributes == null) {
    metaAttributes = new HashMap<String, MetaAttribute>();
  }
  // All generated classes will extend com.abc.Test class
  MetaAttribute extendsAttribute = new MetaAttribute("extends");
  extendsAttribute.addValue("com.abc.Test");
  metaAttributes.put("extends", extendsAttribute);
  return metaAttributes;
}