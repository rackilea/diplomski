FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
DocumentReference docRef = rootRef.collection("session").document(docId);
docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                //Add attendance record to the attendance collection
            } else {
                Log.d(TAG, "No such document");
            }
        }
    }
});