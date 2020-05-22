if(daysLeft<0) {
    mFirebaseDatabaseReference.child(CODEFROGDB)
        .addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long now = System.currentTimeMillis();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Long bday_p = ds.child("bday_p").getValue(Long.class);
                    if(bday_p < now) {
                        ds.child("bday_p").getRef().setValue(bday_p + 31556952000L);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
    });
}