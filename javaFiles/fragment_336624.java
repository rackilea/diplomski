mapExtensionTypes(Types.class, SchemaConstants.Q_ELEM_XSD_1999,
    SchemaImpl.class);
registerDeserializer(Types.class, SchemaConstants.Q_ELEM_XSD_1999,
    new SchemaDeserializer());
registerSerializer(Types.class, SchemaConstants.Q_ELEM_XSD_1999,
    new SchemaSerializer());

mapExtensionTypes(Types.class, SchemaConstants.Q_ELEM_XSD_2000,
    SchemaImpl.class);
registerDeserializer(Types.class, SchemaConstants.Q_ELEM_XSD_2000,
    new SchemaDeserializer());
registerSerializer(Types.class, SchemaConstants.Q_ELEM_XSD_2000,
    new SchemaSerializer());

mapExtensionTypes(Types.class, SchemaConstants.Q_ELEM_XSD_2001,
    SchemaImpl.class);
registerDeserializer(Types.class, SchemaConstants.Q_ELEM_XSD_2001,
    new SchemaDeserializer());
registerSerializer(Types.class, SchemaConstants.Q_ELEM_XSD_2001,
    new SchemaSerializer());