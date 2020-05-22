public class Function {

    @FunctionName("StroageEventGrid")
    @StorageAccount("AzureWebJobsStorage")
    public void run(@EventGridTrigger(name = "blobeventgrid") EventSchema event, 
                    @BlobInput(name = "blob",dataType = "binary",path = "{data.url}") byte[] content,
                    final ExecutionContext context) 
    {
        context.getLogger().info((String)event.data.get("url"));
        if(content != null)
            context.getLogger().info("Length: " + content.length);
        else
            context.getLogger().info("Content is null");
    }
}

public class EventSchema {

  public String topic;
  public String subject;
  public String eventType;
  public Date eventTime;
  public String id;
  public String dataVersion;
  public String metadataVersion;
  public Map<String, Object> data;

}