final JsonGenerator generator = factory.createGenerator(output, JsonEncoding.UTF8);
generator.writeStartArray();
for (String arg: argsList) {
    generator.writeString(arg);
}
generator.writeEndArray();