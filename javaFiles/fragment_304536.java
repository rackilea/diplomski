FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference userExercisesRef = rootRef.collection("userExercises");
Query query = userExercisesRef.whereEqualTo("date", "21-04-2019");
query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            long count = 0;
            for (QueryDocumentSnapshot document : task.getResult()) {
                long timeTrained = document.getLong("timeTrained");
                count = count + timeTrained;
            }

            Log.d(TAG, String.valueOf(count));
        }
    }
});