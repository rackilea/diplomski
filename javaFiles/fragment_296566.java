public void write(XmlSerializer writer) throws IOException {
    writer.setPrefix("i", xsi);
    writer.setPrefix("d", xsd);
    writer.setPrefix("c", enc);
    writer.setPrefix("v", env);
    writer.startTag(env, "Envelope");
    writer.startTag(env, "Header");
    writeHeader(writer);
    writer.endTag(env, "Header");
    writer.startTag(env, "Body");
    writeBody(writer);
    writer.endTag(env, "Body");
    writer.endTag(env, "Envelope");
}