Firebase ref = new Firebase("https://stackoverflow.firebaseio.com/36658910");
    ref.child("time").setValue(ServerValue.TIMESTAMP, listener);
    /*ref.child("time").addListenerForSingleValueEvent(new ValueEventListener() {
        public void onDataChange(DataSnapshot dataSnapshot) {
            System.out.println(dataSnapshot.getValue());
            Long timestamp = (Long) dataSnapshot.getValue();
            System.out.println(timestamp);
            dataSnapshot.getRef().setValue(timestamp);
        }
        public void onCancelled(FirebaseError error) { }
    });*/