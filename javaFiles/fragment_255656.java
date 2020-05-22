@Provider
public class MyDTOWriterInterceptor implements WriterInterceptor {

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) 
            throws IOException, WebApplicationException {
        Object entity = context.getEntity();
        if (entity instanceof MyDTO) {
            ((MyDTO)entity).setDescription("Some Description");
        }
        context.proceed();
    }  
}