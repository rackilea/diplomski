private SampleApplication getSampleApplication() {
    return (SampleApplication)getApplication();
}

private Representation toRepresentation(Map<String, Object> map,
    String templateName, MediaType mediaType) {
    return new TemplateRepresentation(templateName,
        getSampleApplication().getConfiguration(), map, mediaType);
}

@Get("html")
public Representation getHtml() {
    Map<String, Object> model = new HashMap<String, Object>();

    model.put("titre", "my title");
    model.put("users", getUsers());

    return toRepresentation(model,
        "myTemplate", MediaType.TEXT_HTML);
}