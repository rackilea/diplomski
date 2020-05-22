if(filePath != null) {
    mStorageRef.child(bookid[0]).putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            Task<Uri> downloadUrl = taskSnapshot.getMetadata().getReference().getDownloadUrl();
            Toast.makeText(UploadBook.this, "Upload successful", Toast.LENGTH_SHORT).show();
            dbreference.child("books").child(item).child(bookid[0]).child("pics").setValue(downloadUrl.toString());
        }
    })
    .addOnFailureListener(new OnFailureListener() {
         @Override
         public void onFailure(@NonNull Exception e) {

        }
     });
}