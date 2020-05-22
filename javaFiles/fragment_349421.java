txvEmail = (TextView) findViewById(R.id.txvEmail);
txvEmail.setText("Welcome "+user.getEmail());

txvName = (TextView) findViewById(R.id.txvName);
txvAdd =(TextView) findViewById(R.id.txvAdd);

userDatabase = new UserDatabase();

reff = FirebaseDatabase.getInstance().getReference("Member").child(userid);
reff.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        //new code
        for(DataSnapshot snap: dataSnapshot.getChildren()){
            //you must define your class model to the value of snapshots
            userDatabase user = snap.getValue(userDatabase.Class);
             txvName.setText(" "+user.getFirstName()+" "+user.getLastName());
       }


    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});