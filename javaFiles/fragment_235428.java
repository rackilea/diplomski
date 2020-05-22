private String renderMustacheContent() throws IOException {
    MustacheFactory mf = new DefaultMustacheFactory();
    Mustache mustache;

    if (type.getTemplate().trim().isEmpty()) {            
        String emailContent = genCpuEmailContent(cmsKey);
        mustache = mf.compile(new StringReader(emailContent), "cpu.template.email");
    } else {
        mustache = mf.compile(type.getTemplate());
    }

    StringWriter writer = new StringWriter();
    mustache.execute(writer, values).flush();

    return writer.toString();
}