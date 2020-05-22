StorageBatch batch = storage.batch();
 BlobId firstBlob = BlobId.of("bucket", "blob1"));
 BlobId secondBlob = BlobId.of("bucket", "blob2"));
 batch.delete(firstBlob).notify(new BatchResult.Callback<Boolean, StorageException>() {
   public void success(Boolean result) {
     // deleted successfully
   }

   public void error(StorageException exception) {
     // delete failed
   }
 });
 batch.update(BlobInfo.builder(secondBlob).contentType("text/plain").build());
 StorageBatchResult<Blob> result = batch.get(secondBlob);
 batch.submit();
 Blob blob = result.get(); // returns get result or throws StorageException