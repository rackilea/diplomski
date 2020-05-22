Schema dowSchema = SchemaBuilder.array(Schema.STRING_SCHEMA).build();
    Schema airingToItemSchema = SchemaBuilder.struct()
            .field("dow", dowSchema)
            .build();
    Schema airingToSchema = SchemaBuilder.array(airingToItemSchema).build();
    Schema rootSchema = SchemaBuilder.struct()
            .field("airingTo", airingToSchema);
            .build();

    Struct item = new Struct(airingToItemSchema)
            .put("dow", Collections.singletonList("SATURDAY"));
    Struct rootStruct = new Struct(rootSchema)
            .put("airingTo", Collections.singletonList(item));

    System.out.println(rootStruct);