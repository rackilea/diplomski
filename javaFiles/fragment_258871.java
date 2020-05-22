interface OnTransactionListReceivedListener {
     void onTransactionListReceived(List<Transaction> result);
}

public void getTransactions(OnTransactionListReceivedListener listener){

  //initializing firebase auth object
  firebaseAuth = FirebaseAuth.getInstance();
  FirebaseUser currentUser = firebaseAuth.getCurrentUser();
  //Establishing database connection
  db = FirebaseFirestore.getInstance();

  DocumentReference docRef = db.collection("users").document(currentUser.getEmail());

  docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
      @Override
      public void onComplete(@NonNull Task<DocumentSnapshot> task) {

          if (task.isSuccessful()) {
              DocumentSnapshot document = task.getResult();
              if (document.exists()) {
                listener.onTransactionListReceived((ArrayList<Transaction>) document.getData().get("transactions"));
              } else {
                  Log.d(TAG, "No such document");
              }
          } else {
              Log.d(TAG, "get failed with ", task.getException());
          }
      }
  });;
}