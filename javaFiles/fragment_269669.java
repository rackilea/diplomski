storageRef.child("users/me/profile.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
        @Override
        public void onSuccess(Uri uri) {
            // Got the download URL for 'users/me/profile.png'
            Uri downloadUri = taskSnapshot.getMetadata().getDownloadUrl();
            generatedFilePath = downloadUri.toString(); /// The string(file link) that you need
        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception exception) {
            // Handle any errors
        }
    });