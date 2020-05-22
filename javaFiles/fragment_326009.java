Integer value = dataSnapshot.child(user.getUid()).child("points").getValue(int.class);
if (value != null) {
    points = value;
} else {
    // TODO
    // points = ???
}