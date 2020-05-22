yourDocumentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                Map<String, Object> map = document.getData();
                if (map.size() == 0) {
                    Log.d(TAG, "Document is empty!");
                } else {
                    Log.d(TAG, "Document is not empty!");
                }
            }
        }
    }
});