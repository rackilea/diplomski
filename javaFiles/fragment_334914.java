Context context = new VelocityContext();

Template template = Velocity.getTemplate("src/main/resources/defaults.vm");
template.merge(context, NullWriter.NULL_WRITER);

StringWriter writer = new StringWriter();
Template toBeParsedTemplate = Velocity.getTemplate("src/main/resources/test1.vm");
toBeParsedTemplate.merge(context, writer);

String renderedContent = writer.getBuffer().toString();
System.out.println(renderedContent);