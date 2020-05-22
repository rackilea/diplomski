private void downloadImgFromFStorageToLocalFile(StorageReference fileRef) {
    if (fileRef != null) {
        progressDialog.setTitle("Downloading...");
        progressDialog.setMessage(null);
        progressDialog.show();

        try {
            final File localFile = File.createTempFile("images", "jpg");

            fileRef.getFile(localFile).addOnSuccessListener(new 
                OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot 
                 taskSnapshot) {
                    Bitmap bmp = 
                    BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    imgViewProfile.setImageBitmap(bmp);
                    progressDialog.dismiss();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, exception.getMessage(), 
                    Toast.LENGTH_LONG).show();
                }
            }).addOnProgressListener(new 
                OnProgressListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onProgress(FileDownloadTask.TaskSnapshot 
                 taskSnapshot) {
                    // progress percentage
                    double progress = (100.0 * 
                      taskSnapshot.getBytesTransferred()) / 
                      taskSnapshot.getTotalByteCount();
                    // percentage in progress dialog
                    progressDialog.setMessage("Downloaded " + ((int) progress) 
                                                            + "%...");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        Toast.makeText(MainActivity.this, "File ref is null", 
             Toast.LENGTH_LONG).show();
    }
}