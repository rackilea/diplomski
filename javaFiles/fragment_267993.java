@Override
public void onDataChange(DataSnapshot dataSnapshot){
    if(!dataSnapshot.exists()) {
        databaseUser.child(user.getUserId()).child("userHasInterest").child(event.getEventId()).setValue(event.getEventId());
        updateCount(databaseEvent.child(event.getEventId()).child("eventAmount")); //New line here
    } else {
        //event already exists
    }
}