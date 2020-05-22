dbreference.addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot snapshot) {
    if (snapshot.exists()) {
      // TODO: handle the case where the data exists

      for (DataSnapshot data : snapshot.getChildren()) {

            final Books b1 = data.getValue(Books.class);
              //  Log.e("Value is ",dataSnapshot.getKey()+" 
              "+b1.getBauthor());
              //Log.e("Book"," received");

              child_count++;
              list.add(b1);
              staggeredBooksAdapter.notifyDataSetChanged();
              progressDialog.dismiss();

      }
    }
    else {
              // TODO: handle the case where the data does not yet exist
              progressDialog.dismiss();
              Toast.makeText(SubjectBooks.this, "No books   
              found!", Toast.LENGTH_SHORT).show();
              Intent in = new Intent(SubjectBooks.this, 
              MainActivity.class);
              startActivity(in);
              finish();
    }
  }

  @Override
  public void onCancelled(FirebaseError firebaseError) { }
});