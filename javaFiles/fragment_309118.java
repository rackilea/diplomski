FirebaseDatabase.getInstance().getReference("NoteList").child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
  @Override
  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    for (DataSnapshot noteSnapshot: dataSnapshot.getChildren()) {
      System.out.println("Reading note from "+noteSnapshot.getKey());

      NotesList notelist = noteSnapshot.getValue(NotesList.class);

      Title.setText(notelist.getTitle());
      text.setText(notelist.getText());
    }
  }
  ...