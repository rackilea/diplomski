String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference didGameEndRef = rootRef
    .child("PVP")
    .child("active")
    .child(uid)
    .child("didGameEnd");
didGameEndRef.setValue(true);