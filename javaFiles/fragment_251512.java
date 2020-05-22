void uploadFile(final String filePath,final String name){
        Log.e("TopMeme","upload beginning for "+name+" @ "+filePath);

        //cant perform network tasks on main thread
        AsyncTask<Void,Void,Void> task = new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    // Retrieve storage account from connection-string.
                    CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

                    // Create the blob client.
                    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

                    // Retrieve reference to a previously created container.
                    CloudBlobContainer container = blobClient.getContainerReference("memecontainer");

                    /*
                    //create blob if it doesn't exist - hopefully resolves bugs
                    container.createIfNotExists();

                    // Create a permissions object.
                    BlobContainerPermissions containerPermissions = new BlobContainerPermissions();

                    // Include public access in the permissions object.
                    containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);

                    // Set the permissions on the container.
                    container.uploadPermissions(containerPermissions);
                    */

                    // Create or overwrite the "myimage.jpg" blob with contents from a local file.
                    CloudBlockBlob blob = container.getBlockBlobReference(name);
                    File source = new File(filePath);
                    Log.e("TopMeme","File size: "+source.length());
                    FileInputStream fileInputStream = new FileInputStream(source);
                    Log.e("TopMeme","available: "+fileInputStream.available());
                    blob.upload(fileInputStream, source.length());
                    Log.e("TopMeme","upload function completed");
                }
                catch (Exception e)
                {
                    // Output the stack trace.
                    e.printStackTrace();
                    Log.e("TopMeme","upload failed: "+e);
                }
                return null;
            }
        };

        task.execute();
    }