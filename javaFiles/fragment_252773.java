public class MessageAttachmentTransformer extends AbstractMessageTransformer
{private List<String> filename; // file to attach
    @SuppressWarnings("deprecation")
    public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
        if (filename.isEmpty() || filename==null || filename.size()==0) **//filename is a list contains list of file path as mule attachment**
        {**//If file for attachment is not there**
            **//Here I want to place FileNotFoundException**
            return message;} else
        { // do other thing} return message;
        } 
    }
}