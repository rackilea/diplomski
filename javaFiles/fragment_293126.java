final TableDescription description = table.describe();
System.out.println(description.getAttributeDefinitions());
final List<AttributeDefinition>
    tableAttributeDefinitions =
    description.getAttributeDefinitions();
for (GlobalSecondaryIndexDescription gsi : description
    .getGlobalSecondaryIndexes()) {
    System.out.println("IndexName: " + gsi.getIndexName());
    for (KeySchemaElement keySchemaElement : gsi.getKeySchema()) {
        final String attrName = keySchemaElement.getAttributeName();
        final AttributeDefinition
            attrDef =
            tableAttributeDefinitions.stream()
                .filter(ad -> ad.getAttributeName().equals(attrName)).findFirst()
                .orElseThrow(RuntimeException::new);
            System.out.println(
                "AttributeName: " + attrDef.getAttributeName() +
                ", AttributeType: " + attrDef.getAttributeType());
    }
}