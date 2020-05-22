ref.orderByChild("randomLong").startAt(newRandomLong).limitToFirst(1).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getChildrenCount() > 0){
            for(DataSnapshot snap : dataSnapshot.getChildren()){
                //Do something with your random snapshot
            }
        }else
        {
         /*
         Handle case where the new random Long is after the range 
         currently in the database
         ref.orderByChild("randomLong").endAt(random).limitToLast(1)
         */
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});