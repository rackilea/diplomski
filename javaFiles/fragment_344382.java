StorageReference mImageStorage = FirebaseStorage.getInstance().getReference();
        StorageReference ref = mImageStorage.child("storage name")
                .child("your image name.jpg");

        ref.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downUri = task.getResult();
                    String imageUrl = downUri.toString();
                    Toast.makeText(MainActivity.this, imageUrl , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show(); 
                }
            }
        });