ResultSet rs = (ResultSet) statement.getObject(P_CURSOR);

        StringWriter writer = new StringWriter();
        JsonFactory jsonfactory = new JsonFactory();
        JsonGenerator jsonGenerator = jsonfactory.createJsonGenerator(writer);

        jsonGenerator.writeStartArray();
        while (rs.next()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField(KEY1, rs.getString(KEY1));
            jsonGenerator.writeStringField(KEY2, rs.getString(KEY2));
            jsonGenerator.writeStringField(KEY3, rs.getString(KEY3));
            jsonGenerator.writeEndObject();
        }

        jsonGenerator.writeEndArray();
        jsonGenerator.close();