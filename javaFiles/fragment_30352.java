String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference usersRef = rootRef.collection("users");
usersRef.document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        DocumentSnapshot document = task.getResult();
        if (document.exists()) {
            Date creationDate = document.getDate("creationDate");
            //Do what you need to do with your Date object
        }
    }
});