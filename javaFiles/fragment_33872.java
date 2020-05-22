final ProgressDialog mDialog;

private void initDataChangeListener() {

  table_user.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
      ...
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
  });
}