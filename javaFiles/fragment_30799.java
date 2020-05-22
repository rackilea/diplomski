DocumentReference docRef = db.collection("events");
docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
    @Override
    public void onSuccess(DocumentSnapshot documentSnapshot) {
        EventComment comment = documentSnapshot.toObject(EventComment.class);
    }
});