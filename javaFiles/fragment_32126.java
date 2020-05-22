public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
    if (task.isSuccessful()) {
            Toast.makeText(RoleInfo2.this, "Your picture Saved successfully", Toast.LENGTH_SHORT).show();
            link=task.getResult().getStorage().getDownloadUrl().toString();

            Signup();
        }
    }