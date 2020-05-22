Firebase ref = new Firebase("<my-firebase-app>/names"):
Firebase johnRef = ref.child("john");
johnRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
       System.out.println(snapshot.value); // the String "John"
    }
    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
});