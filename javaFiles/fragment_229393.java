// Step 2: Upload parts.
long filePosition = 0;
for (int i = 1; filePosition < contentLength; i++) {
    // Last part can be less than 5 MB. Adjust part size.
    partSize = Math.min(partSize, (contentLength - filePosition));

    // Create request to upload a part.
    UploadPartRequest uploadRequest = new UploadPartRequest()
                .withBucketName(existingBucketName).withKey(keyName)
                .withUploadId(initResponse.getUploadId()).withPartNumber(i)
                .withFileOffset(filePosition)
                .withFile(file)
                .withPartSize(partSize);

    // repeat the upload until it succeeds.
    boolean anotherPass;  
        do {
              anotherPass = false;  // assume everythings ok
              try {
                  // Upload part and add response to our list.
                  partETags.add(s3Client.uploadPart(uploadRequest).getPartETag());
              } catch (Exception e) {
                    anotherPass = true; // repeat
              }
        } while (anotherPass);

     filePosition += partSize;
}

   // Step 3: complete.
   CompleteMultipartUploadRequest compRequest = new 
                     CompleteMultipartUploadRequest(
                                existingBucketName, 
                                keyName, 
                                initResponse.getUploadId(), 
                                partETags);

   s3Client.completeMultipartUpload(compRequest);