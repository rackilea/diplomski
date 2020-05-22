private void generateUserName(){
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    db = FirebaseFirestore.getInstance();
    db.collection("users").document(user.getEmail())
            .get()
            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
        @Override
        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
            userName = task.getResult().get("name").toString();
        }
    });
}