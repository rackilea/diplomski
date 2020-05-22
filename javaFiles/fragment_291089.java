BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);

  for (String key : blobs.keySet()) 
    {     
        for (BlobKey value : blobs.get(key)) 
        {
           String x =value.getKeyString()
        }
     }