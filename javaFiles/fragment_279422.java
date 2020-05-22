private void uploadImageAndGetURL(String ImageId) {

    final StorageReference filePath = storageImage.child(ImageId + ".jpg");

    UploadTask uploadTask = filePath.putFile(imageUri);

    uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
        @Override
        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
            if (!task.isSuccessful()) {
                throw task.getException();
            }
            // Continue with the task to get the download URL
            return filePath.getDownloadUrl();
        }
    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
        @Override
        public void onComplete(@NonNull Task<Uri> task) {

            if (task.isSuccessful()) {

                downloadURL = task.getResult().toString();

                storeDataToFirebase();

            } else {

                Toast.makeText(AddAdsActivity.this, "There has bean a problem in the database.", Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();

            }
        }
    });

}