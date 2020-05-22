import org.glassfish.jersey.server.ContainerResponse;

public class GLExportTransformer extends AbstractMessageTransformer {

    @Override
    public Object transformMessage(MuleMessage message, String outputEncoding)throws TransformerException {
        ContainerResponse cr = (ContainerResponse) message.getInvocationProperty("jersey_response");
        List<GLExport> res = (List<GLExport>)cr.getEntity();
        return res;   
    }

}