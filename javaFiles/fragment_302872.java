public List<CsdlSchema> getSchemas() throws ODataException {
    CsdlSchema schema = new CsdlSchema();
    // ...
    List<CsdlEnumType> enumTypes = new ArrayList<CsdlEnumType>();
    enumTypes.add(getEnumType(CET_ROLECAT));
    schema.setEnumTypes(enumTypes);
    // ...
    List<CsdlSchema> schemas = new ArrayList<CsdlSchema>();
    schemas.add(schema);
    return schemas;
}