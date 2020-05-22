public interface OnCheckUserExist {
    void exist();
    void notExist();
}

registerRepo.checkUserExists(emailAddress, emailDomain, new OnCheckUserExist(){
   @Override
   public void exist(){
       Toast toast = Toast.makeText(getBaseContext(), "User exists",Toast.LENGTH_SHORT);
       toast.show();
   }
   @Override
   public void notExist(){
       User user = new User(firsName, lastName, emailAddress, emailDomain);
       registerRepo.writeUser(user);
   }
})


public void checkUserExists(final String emailAddress, final String emailDomain, OnCheckUserExist onCheckUserExist){
    DatabaseReference myRef = database.getReference("Users");
    myRef.addValueEventListener(new ValueEventListener() {
        boolean userExist;

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot mydata : dataSnapshot.getChildren()){
                User user = mydata.getValue(User.class);

                if (user.getEmailAddress().equals(emailAddress) &&
                        user.getEmailDomain().equals(emailDomain)){
                    onCheckUserExist.exist();
                    userExist = true;
                    break;
                }
            }
            if (!userExist){
              onCheckUserExist.notExist();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
}