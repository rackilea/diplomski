final StorageReference ref = mStorageRef.child(bookid[0]);
UploadTask uploadTask = ref.putFile(file);

Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
    @Override
    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
        if (!task.isSuccessful()) {
            throw task.getException();
        }
        return ref.getDownloadUrl();

    }
    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
        @Override
        public void onComplete(@NonNull Task<Uri> task) {
            if (task.isSuccessful()) {
                Uri downloadUri = task.getResult();
                dbreference.child("books").child(item).child(bookid[0]).child("pics").setValue(downloadUri.toString());
            } else {
                 // Handle failures
            }
       }
});