databaseReference.child(userID).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
        fName.setText(userInformation.getUserFName());
        lName.setText(userInformation.getUserLName());
        email.setText(userInformation.getUserEmail());
        aboutYou.setText(userInformation.getUserDescription());
    }
}