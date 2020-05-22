public List<User> getUsers(){
    ref.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            try{
                for(DataSnapshot childSnapshot: dataSnapshot.getChildren()){
                    User User = childSnapshot.getValue(User.class);
                    usersList.add(User);
                        User[] UserArray = new User[usersList.size()];
                        UserArray = usersList.toArray(UserArray);
                    for(int i = 0;i < usersList.size(); i++){
                        Log.d("NAME", UserArray[i].getUserName());
                    }


                }
            }catch (Exception e){
                Log.d("Error in the try", e.getMessage());
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.i("ERROR", databaseError.getMessage());
        }
    });

    return usersList;
}