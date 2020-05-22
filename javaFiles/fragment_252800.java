adapter = new Adapter(this, list);
view= findViewById(R.id.my_view);
view.setLayoutManager(manager);
view.setAdapter(adapter);
getListFromFirebase(); // Dont return anything from this method. declare it void


void getListFromFirebase(){
  //firebaselistener task
   onChildAdded(){

     YourModel yourModel = dataSnapshot.getValue();
     mAdapter.addNewData(yourModel); //create a new method to update recyclerview Adapter
   }
}