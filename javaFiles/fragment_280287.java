reference.putFile(data)
    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


            Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
            uriTask.addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Uri url = uriTask.getResult();

                    uploadPDF uploadPDF = new uploadPDF(editPDFName.getText().toString(),url.toString());
                    databaseReference.child(databaseReference.push().getKey()).setValue(uploadPDF);


                    Toast.makeText(MainActivity.this, "File uploaded", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                }
            });
        }
    }).addOnProgressListener(