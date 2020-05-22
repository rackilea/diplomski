Query q;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    q =  FirebaseDatabase.getInstance().getReference("Messages").child("id1").child("id2").orderByChild("Seen").equalTo(0);
    q.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot ds: dataSnaphot.getChildren()) {
                ds.getRef().child("Seen").setValue(1);
            }
        } 

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }   
    });
}