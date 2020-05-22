boolean CheckExists =false;   //declare and assign default value in global scope

reference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        Iterable<DataSnapshot> userChildren = dataSnapshot.getChildren();

        for (DataSnapshot user: userChildren) {
            User u = user.getValue(User.class);      //make a model User with necessary fields

            if(u.email.equalsIgnoreCase(Email.getText().toString())){
                CheckExists =true;
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});