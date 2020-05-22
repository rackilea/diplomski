mStoreBaseRef.collection("ABC").add(pollMap)
            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
        @Override
        public void onComplete(@NonNull Task<DocumentReference> task) {
            if (task.isSuccessful()) {
                DocumentReference docRef = task.getResult();
                String key = docRef.getId();
                Log.v("KEY", key);
                Toast.makeText(getApplicationContext(), key, Toast.LENGTH_LONG).show();
            }
        }
    });