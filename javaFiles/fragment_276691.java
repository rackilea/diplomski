jgen.writeStartObject();
        jgen.writeNumberField("id", value.id);
        jgen.writeStringField("itemName", value.itemName);

        jgen.writeObjectFieldStart("owner");
        jgen.writeNumberField("id", value.owner.id);
        jgen.writeStringField("name", value.owner.name);
        jgen.writeEndObject();

        jgen.writeEndObject();