public static class FolderPageSearialer extends JsonSerializer<FolderPage> {

        @Override
        public void serialize(FolderPage o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            List<ApplicationIcon> applications = o.getApplications();
            jsonGenerator.writeStartArray(applications.size());
            for (ApplicationIcon application : applications) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName("application");
                jsonGenerator.writeStartObject();
                jsonGenerator.writeStringField("id", application.getId());
                jsonGenerator.writeStringField("name", application.getName());
                jsonGenerator.writeEndObject();
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }
    }