DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    Query query=databaseReference.child(Constants.ARG_CHAT_ROOMS).child("tKyhXXAf6TQnQgKyAf23RJcwhsn1_S5ClzMeWUEXR9evLJO9CBd9ABCH3").orderByChild().limitToLast("Number of last messages you want to show");
    query.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                Chat chat=snapshot.getValue(Chat.class);
                Log.e("163","ACV"+chat.fromEmail);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });