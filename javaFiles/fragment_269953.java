AmazonS3 amazons3Client = new AmazonS3Client(new ProfileCredentialsProvider());
     public void createFolder(String bucketName, String folderName)
        {
            try
            {

                        ObjectMetadata objectMetaData = new ObjectMetadata();
                        objectMetaData.setContentLength(0);
                        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
                        amazons3Client.putObject(new PutObjectRequest(bucketName, folderName + "/", emptyContent, objectMetaData));
            }
            catch (Exception exception)
            {
                LOGGER.error("Exception In Create Folder", exception);
            }

        }