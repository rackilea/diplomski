DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    List<BlobInfo> blobsToCheck = new LinkedList<BlobInfo>(); 
    Iterator<BlobInfo> iterator = null;
    if(afterBlobKey == null){
        iterator = new BlobInfoFactory().queryBlobInfos();
    }else{
        iterator = new BlobInfoFactory().queryBlobInfosAfter(new BlobKey(afterBlobKey));
    }

    while(iterator.hasNext()){

        blobsToCheck.add(iterator.next());

    }

    //Check those blobs if they have reference in datastore
    //Delete using blobstoreService.delete(blobKey);