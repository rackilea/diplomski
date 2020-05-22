db.collection("cities").add(city).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
    @Override
    public void onComplete(@NonNull Task<DocumentReference> task) {
        if (task.isSuccessful()) {
            DocumentReference document = task.getResult();
            if (document != null) {
                String id = document.getId(); //Do what you need to do with the document id
                Log.d(TAG, id);
            }
        }
    }
});