database = FirebaseDatabase.getInstance();
mDatabaseRef = database.getReference();

mDatabaseRef
    .child("users")
    .child(Login.userId)
    .child("categories")
    .setValue(categories)
    .addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {

            if (task.isSuccessful()) {

                //Update success
            } else {

                //Update fail
            }
        }
    });