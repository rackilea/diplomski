private void delete() {

fbDbRef.addListenerForSingleValueEvent(new ValueEventListener() {

        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                final String pushKey = snapshot.getKey();
                Log.d(TAG, "pushKey: " + pushKey);
                fbDbRef.child(pushKey).child("phone").removeValue();

            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });

}