dbRef = FirebaseDatabase.getInstance().getReference().child("Ranklist");
Query lastQuery = dbRef.orderByKey().limitToLast(1);
lastQuery.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
     for(DataSnapshot data : dataSnapshot.getChildren())
     {
       //if you call methods on dataSnapshot it gives you the required values
       String s = data.getValue(); // then it has the value "somekey4" 
       String key = data.getKey(); // then it has the value "4:"
       //as per your given snapshot of firebase database data 
      }
}

@Override
public void onCancelled(DatabaseError databaseError) {

}});