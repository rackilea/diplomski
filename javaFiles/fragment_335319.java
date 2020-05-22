db.collection(DATABASE).add(O)
        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.w(TAG, "Document upload complete");
                callback.result(Result.SUCCESS);
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding uploading document", e);
                callback.result(Result.FAILED);
            }
        });