//declare the Strings before


DatabaseReference newtables = FirebaseDatabase.getInstance().getReference().child("Oli");
newtables.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            values = dataSnapshot.child("harga").getValue().toString();
jenis=dataSnapshot.child("jenis").getValue().toString();
kap=dataSnapshot.child("kapasitas").getValue().toString();
kat=dataSnapshot.child("kategori").getValue().toString();
merk=dataSnapshot.child("merk").getValue().toString();
nama=dataSnapshot.child("nama").getValue().toString();
            DatabaseReference 
joins=FirebaseDatabase.getInstance().getReference().child("Kategori");
joins.orderByKey().equalTo(kat).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        retrieve = dataSnapshot.child("nama").getValue().toString();

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });