String connectionString = "<your storage connection string>"
String containerName = "<your container name>";
String blobName = "<your blob name>";
CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
CloudBlobClient client = account.createCloudBlobClient();
CloudBlobContainer container = client.getContainerReference(containerName);
CloudBlockBlob blob = container.getBlockBlobReference(blobName);
SharedAccessBlobPolicy policy = new SharedAccessBlobPolicy();
policy.setPermissions(EnumSet.allOf(SharedAccessBlobPermissions.class));
policy.setSharedAccessStartTime(Date.valueOf(LocalDate.now().minusYears(2)));
policy.setSharedAccessExpiryTime(Date.valueOf(LocalDate.now().plusYears(2)));
String sas = blob.generateSharedAccessSignature(policy, null);
String urlWithSas = String.format("%s?%s", blob.getUri(), sas);