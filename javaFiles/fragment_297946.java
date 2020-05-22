S3Object object = s3.getObject(new GetObjectRequest(bucketName, key));
    InputStream is = object.getObjectContent();



 // Creating file
        File file= new File(localFilePath);
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos= new BufferedOutputStream(fos);

    int read = -1;

    while ((read = is.read()) != -1) {
        bos.write(read);
    }

    bos.flush();
    bos.close();
    is.close();