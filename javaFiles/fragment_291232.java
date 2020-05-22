StorageCredentials credentials = new StorageCredentialsAccountAndKey(accountName, accountKey);
 CloudStorageAccount connection = new CloudStorageAccount(credentials, true);
 CloudBlobClient blobClient = connection.createCloudBlobClient();
 CloudBlobContainer container = blobClient.getContainerReference(containerName);

 CloudBlob blob = container.getBlockBlobReference(fileName);

 Configuration config = new Configuration();
 config.set("fs.azure", "org.apache.hadoop.fs.azure.NativeAzureFileSystem");
 config.set("fs.azure.sas.<containerName>.<accountName>.blob.core.windows.net", token);
 URI uri = new URI("wasbs://<containerName>@<accountName>.blob.core.windows.net/" + blob.getName());
 InputFile file = HadoopInputFile.fromPath(new org.apache.hadoop.fs.Path(uri),
                config);
 ParquetReader<GenericRecord> reader = AvroParquetReader.<GenericRecord> builder(file).build();

 GenericRecord record;
 while ((record = reader.read()) != null) {
     System.out.println(record);
 }
 reader.close();