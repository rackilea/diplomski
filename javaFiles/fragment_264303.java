if (attribute.getPersistentAttributeType() == Attribute.PersistentAttributeType.BASIC || 
    attribute.getPersistentAttributeType() == Attribute.PersistentAttributeType.EMBEDDED ) {
    throw new IllegalArgumentException(
        String.format("Attribute [%s] is not of managed type", getAttributeName())
    );
}