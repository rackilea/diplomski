@Override
public void isUserExists(final String username, String email) throws 
 UserExistsException {

     CollectionReference allUsersRef = db.collection(COLLECTION_NAME);
     Query userNameQuery = allUsersRef.whereEqualTo(KEY_USERNAME, username);
     userNameQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
       @Override
       public void onComplete(@NonNull Task<QuerySnapshot> task) {
          if (task.isSuccessful()) {
               for (DocumentSnapshot document : task.getResult()) {
                  if (document.exists()) {
                     String userName = document.getString(username);
                     Log.d(TAG, "username already exists");
                  } else {
                     Log.d(TAG, "username does not exists");
                  }
               }
          } else {
             Log.d("TAG", "Error getting documents: ", task.getException());
          }
      }
    });
}