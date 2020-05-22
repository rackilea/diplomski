/**
 * Creates a new field model instance.
 * @param builder The builder.
 */
private DynamoDBMapperFieldModel(final Builder<T,V> builder) {
    this.id = builder.id;
    this.properties = builder.properties;
    this.reflect = builder.reflect;
    this.converter = builder.converter;
    this.dynamoDBAttributeType = builder.dynamoDBAttributeType;
}