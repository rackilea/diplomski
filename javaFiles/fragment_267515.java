public static class OptionalAwareAnnotationIntrospector
        extends JacksonAnnotationIntrospector {
    @Override
    public JsonInclude.Value findPropertyInclusion(Annotated a) {
        if (Optional.class.equals(a.getRawType())) {
            return JsonInclude.Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.NON_NULL);
        }
        return super.findPropertyInclusion(a);
    }
}

private ObjectMapper initObjectMapper() {
    return new ObjectMapper()
            .registerModule(new Jdk8Module())
            .setSerialisationInclusion(JsonInclude.Include.ALWAYS)
            .setAnnotationIntrospector(new OptionalAwareAnnotationIntrospector());
}