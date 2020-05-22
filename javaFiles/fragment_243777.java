private void updateShowing(final boolean isShow) {

    removeStudentMarkers();

    FirebaseDatabase.getInstance().getReference().child("Students")
        .addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot snapshot) {
            for (DataSnapshot ds : snapshot.getChildren()) {
              ds.child("show").getRef().setValue(isShow);
            }
          }

          @Override
          public void onCancelled(DatabaseError error) {
            Log.i( "onCancelled: ", error.getDetails() +"\n "+ error.getMessage());
          }
        });
    }