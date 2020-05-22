CloudBlockBlob blockBlob = container.getBlockBlobReference(‘myblob’); // assuming container was already created

    BlobOutputStream blobOutputStream = blockBlob.openOutputStream();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer); // assuming buffer is a byte[] with your data

    int next = inputStream.read();
    while (next != -1) {
          blobOutputStream.write(next);
          next = inputStream.read();
    }

    blobOutputStream.close();