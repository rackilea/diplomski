firestore.collection("root_collection").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            List<String> list = new ArrayList<>();
            for (QueryDocumentSnapshot document : task.getResult()) {
                list.add(document.getId());
            }
            Log.d(TAG, list.toString());
        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});