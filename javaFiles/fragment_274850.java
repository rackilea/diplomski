FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser currUser = FirebaseAuth.getInstance().getCurrentUser();
    final DocumentReference userDocRef = db.collection("Users").document(currUser.getEmail());
    //access current values saved under this user
    userDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {
            User currentUser = documentSnapshot.toObject(User.class);
            warmups_skipped = currentUser.getWarmupsSkipped()+1;
            Map<String, Object> update = new HashMap<>();
            update.put(WARMUPSSKIPPED, warmups_skipped);
            userDocRef
                    .set(update, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG, "Document has been saved");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, "Document could not be saved" +e.toString());
                }
            });
            Log.d(TAG, "DocumentSnapshot successfully retrieved! " + warmups_skipped);
        }
    });