private void moveRecord(DatabaseReference fromPath, final DatabaseReference toPath) {
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            toPath.setValue(dataSnapshot.getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isComplete()) {
                        Log.d(TAG, "Success!");
                    } else {
                        Log.d(TAG, "Copy failed!");
                    }
                }
            });
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {}
    };
    fromPath.addListenerForSingleValueEvent(valueEventListener);
}