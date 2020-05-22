fireRef.putFile(ImageUri)
    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                }
            } , 5000);

            Toast.makeText(MainActivity.this, "Upload Successfull", Toast.LENGTH_SHORT).show();
            Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
            while (!urlTask.isSuccessful());
            Uri downloadUrl = urlTask.getResult();
            Upload upload = new Upload(mainEditTextNotify.getText().toString().trim(),
                    downloadUrl.toString());
            String uploadId = mDataRef.push().getKey();
            mDataRef.child(uploadId).setValue(upload);

        }
    })