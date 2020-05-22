public static void getUserFromId(String userId,OnGetUser callback) {
    dbRef.child("status").child(userId).addListenerForSingleValueEvent(
            new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get user value
                    user[0] = dataSnapshot.getValue(UserModel.class);
                    Log.d("TAG", "Value is: " + dataSnapshot.getValue());
                    Log.d("TAG", "User: " + user);
                    callback.onGetUser();
                    // ...
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("TAG", "getUser:onCancelled", databaseError.toException());
                    // ...
                }
            });
}

interface OnGetUser
{
    void onGetUser();
}