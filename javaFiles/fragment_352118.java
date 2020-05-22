public class ExtendedBufferedImageHttpMessageConverter extends BufferedImageHttpMessageConverter {

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
    if (mediaType.equals(MediaType.ALL)) {
        return super.canWrite(clazz, MediaType.IMAGE_JPEG);
    } else {
        return super.canWrite(clazz, mediaType);
    }
}