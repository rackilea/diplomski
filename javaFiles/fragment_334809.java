ObjectMetadata metadataCopy = new ObjectMetadata();
// copy previous metadata
metadataCopy.addUserMetadata("newmetadata", "newmetadatavalue");

CopyObjectRequest request = new CopyObjectRequest(bucketName, existingKey, bucketName, existingKey)
      .withNewObjectMetadata(metadataCopy);

amazonS3Client.copyObject(request);