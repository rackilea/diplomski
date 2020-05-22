@Provider
public class ChecksumInterceptor implements WriterInterceptor {

    @Override
    public void aroundWriteTo(WriterInterceptorContext context)
            throws IOException, WebApplicationException {

        OutputStream old = context.getOutputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {

            context.setOutputStream(buffer);
            // let MessageBodyWriter do it's job
            context.proceed();

            // get bytes
            byte[] entity = buffer.toByteArray();

            String checksum = ChecksumUtil.createChecksum(entity);
            context.getHeaders().putSingle("X-Checksum", checksum);

            old.write(entity);
        } finally {
            context.setOutputStream(old);
        }
    }
}