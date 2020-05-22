@Provider
public class XmlHeaderWriterInterceptor implements WriterInterceptor {

    @Context
    private ResourceInfo info;

    @Override
    public void aroundWriteTo(WriterInterceptorContext context)
                    throws IOException, WebApplicationException {
        final OutputStream outputStream = context.getOutputStream();

        XmlHeader anno = info.getResourceMethod().getAnnotation(XmlHeader.class);
        if (anno != null) {
            String value = anno.value();
            writeToStream(outputStream, value);
        }
        context.proceed();
    }
}