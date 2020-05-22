final FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference reference = database.getReference("routes").child("-KzdUTraH1BodJMuEnSu").child("markerId");
ValueEventListener ref=new ValueEventListener(){
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot data : dataSnapshot.getChildren()){
            String x=data.getKey();

        DatabaseReference datas=database.getReference().getInstance().child("markers");
        datas.orderByKey().equalTo(x).addValueEventListener(new ValueEventListener()){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //code here
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
               throw databaseError.toException();
            }
        });
      }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
};
reference.addValueEventListener(ref);