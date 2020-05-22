FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference usersRef = rootRef.collection("users");
Query query = usersRef.whereEqualTo("phoneNumber", 123456789);
query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                String userName = document.getString("userName");
                Log.d(TAG, userName);
            }
        }
    }
});