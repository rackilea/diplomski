dataSnapshot.getChildren(); 

    mdatabaseRef.child("order").child(dataSnapshot.getChildren()).



     mdatabaseRef.child("order").addValueEventListener(new ValueEventListener() {
  @Override     
  public void onDataChange(DataSnapshot dataSnapshot) {
     for (DataSnapshot child: dataSnapshot.getChildren()){
        String key = child.getKey();
         fun(key);
         }

  private void fun(String key){

    mdatabaseRef.child("order").child(key).addValueEventListener(new ValueEventListener() {
   @Override     
   public void onDataChange(DataSnapshot dataSnapshot) {for (DataSnapshot child: dataSnapshot.getChildren()){
  String key = child.getKey();
   fun(key);
 }

    }