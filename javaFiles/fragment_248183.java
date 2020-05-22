FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

 if(user!=null){

  Log.i("a user is logged in: ",user);
 }
  else{
       Log.i("Username", "there is no user");
     }