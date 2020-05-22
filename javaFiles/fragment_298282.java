String accountName = "<your-storage-account-name>";
String accountKey = "<your-storage-account-key>";
String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s";
String connectionString = String.format(storageConnectionString, accountName, accountKey);
CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
CloudBlobClient client = account.createCloudBlobClient();
String containerName = "mycontainer";
CloudBlobContainer container = client.getContainerReference(containerName);
long size = 0L;
Iterable<ListBlobItem> blobItems = container.listBlobs();
for (ListBlobItem blobItem : blobItems) {
    if (blobItem instanceof CloudBlob) {
        CloudBlob blob = (CloudBlob) blobItem;
        size += blob.getProperties().getLength();
    }
}