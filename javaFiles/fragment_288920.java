StorageReference ref = storage.getReference();
StorageReference reference = ref.child("images.jpg");

reference.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
@Override
public void onSuccess(StorageMetadata storageMetadata) {
    Log.i("The size of the file is:", storageMetadata.getSizeBytes());
  }
}).addOnFailureListener(new OnFailureListener() {
   @Override
   public void onFailure(@NonNull Exception exception) {

    }
});