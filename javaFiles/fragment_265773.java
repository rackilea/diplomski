String connectionString = "Endpoint=sb://xxxx.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=xxxxxx";
ConnectionStringBuilder connectionStringBuilder = new ConnectionStringBuilder(connectionString);
ManagementClient client = new ManagementClient(connectionStringBuilder);
if(!client.queueExists("queueName"))
{
    QueueDescription queue = client.createQueue("queueName");
}