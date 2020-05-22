public void checkChatRoomMembership(String chatRoomUid) {
mChatRoomMembers.child(chatRoomUid).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (dataSnapshot.hasChild(mAuth.getUid())) {
            // true, do you work here
        } else {
            // false, do you work here
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});