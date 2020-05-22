@Override
public DynamoDBMapperFieldModel getFieldModel(Method getter) {
    //...
    final StandardAnnotationMaps.FieldMap annotations = StandardAnnotationMaps.of(getter, null);
    final DynamoDBMapperFieldModel.Builder builder = new DynamoDBMapperFieldModel.Builder(void.class, annotations);
    builder.with(attributeType);
    return builder.build();
}