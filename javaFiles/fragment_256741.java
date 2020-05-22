mDB.collection("COLLECTION_NAME").document("USER_ID").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            int size = task.getResult().size();
            Log.d(TAG, String.valueOf(size));
        }
    }
});