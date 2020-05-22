// Note: Content Type - might need treatment!
public class AttachmentAttacher{
   public void process(Exchange exchange){
      Message in = exchange.getIn();
      byte[] file = in.getBody(byte[].class);
      String fileId = in.getHeader("CamelFileName",String.class);
      in.addAttachment(fileId, new DataHandler(file,"plain/text"));
    }
}