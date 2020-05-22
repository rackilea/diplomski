DatabaseReference myRef;

     private void sendUserData (){
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            myRef = firebaseDatabase.getReference("Users").child(firebaseAuth.getUid());
            final StorageReference imageReference = storageReference.child(firebaseAuth.getUid()).child("Images").child("Profile Pic");
                                                        //Here the root storage reference of our app storage is is "storageReference".
                                                        //.child(firebaseAuth.getUid()) creates a folder for every user. .child("images")
                                                        //creates another subfolder Images and the last child() function
                                                        //.child("Profile Pic") always gives the name of the file.
                                                        //User id/Images/profile_pic.png
                                                        //We can follow the same process for all other file types.

            if(imageTrue==1){
                UploadTask uploadTask = imageReference.putFile(imagePath);     //Now we need to upload the file.
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "File Upload Failed", Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Uri downloadUri = uri;
                                imageUri = downloadUri.toString();
                                saveUserDetails(imageUri); // Image uploaded
                            }
                        });
                        Toast.makeText(getApplicationContext(), "File Uploaded Successfully", Toast.LENGTH_SHORT).show();

                    }
                });
            }else{
                saveUserDetails(""); // Image not uploaded
            }
    }