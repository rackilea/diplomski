FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference allUsersRef = rootRef.collection("all_users");
Query userNameQuery = allUsersRef.whereEqualTo("username", "userNameToCompare");
userNameQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (DocumentSnapshot document : task.getResult()) {
                if (document.exists()) {
                    String userName = document.getString("username");
                    Log.d(TAG, "username already exists");
                } else {
                    Log.d(TAG, "username does not exists");
                }
            }
        } else {
            Log.d("TAG", "Error getting documents: ", task.getException());
        }
    }
});