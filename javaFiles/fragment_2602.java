public int counter = 0;

  private void getDinos() {
  final DatabaseReference dinosDb = 
 FirebaseDatabase.getInstance().getReference().child("Users").child("Dinos");
  dinosDb.addChildEventListener(new ChildEventListener() {
  @Override
  public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable 
 String s) {

    for(DataSnapshot ds : dataSnapshot.getChildren()) {
    if (dataSnapshot.exists()) {
      ArrayList<String> dinoList = new ArrayList<String>() {{
        add("Allosaurus");
        add("Ankylosaurus");
        add("Baryonyx");
        add("Brachiosaurus");
        add("Carnotaurus");
        add("Dilophosaurus");
        add("Diplodocus");
        add("Gallimimus");
        add("Giganotosaurus");
        add("Iguanodon");
        add("Megalosaurus");
        add("Spinosaurus");
        add("Stegosaurus");
        add("Triceratops");
        add("Tyrannosaurus");
        add("Velociraptor");
      }};
      if (!dataSnapshot.child(dinoList.get(i)).child("connections").child("like").hasChild(currentUId) && !dataSnapshot.child(dinoList.get(i)).child("connections").child("dislike").hasChild(currentUId)) {
        Log.d("mine", "" + dataSnapshot + dataSnapshot.child(dinoList.get(counter)).child("connections").child("dislike").hasChild(currentUId));//deze shit gaat dus fout
        cards theItem = new cards(dataSnapshot.getKey(), (String) dataSnapshot.child(dinoList.get(i)).getKey());
        rowItems.add(theItem);
        arrayAdapter.notifyDataSetChanged();
      }
    }
      counter++;
    }
  }

  @Override
  public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

  }

  @Override
  public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

  }

  @Override
  public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

  }

  @Override
  public void onCancelled(@NonNull DatabaseError databaseError) {

  }
});