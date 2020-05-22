userRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        boolean attending = false; 
        for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
            if(eventSnapshot.getKey().equals(THE_DESIRED_EVENT)) {
                attending = true; 
                break;
            }
        }

        if(attending) doSomethingAsUserIsFoundToBeAttendingTheEvent();
        else userIsNotAttending();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});