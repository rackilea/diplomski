public class PrettyPrintJsonConverter extends MappingJackson2HttpMessageConverter {
    public PrettyPrintJsonConverter() {
        setPrettyPrint(true);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(new MediaType("application", "pretty+json"));
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        boolean canWrite = super.canWrite(clazz, mediaType);
        boolean canWritePrettily = mediaType != null && 
                                   mediaType.getSubtype().equals("pretty+json");

        return canWrite && canWritePrettily;
    }
}