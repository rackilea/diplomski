FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference booksRef = rootRef.collection("books");
booksRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (DocumentSnapshot document : task.getResult()) {
                Book book = document.toObject(Book.class);
                //Do whay you need to do with your Book object
            }
        }
    }
});