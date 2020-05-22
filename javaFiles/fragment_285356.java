DatabaseReference userDataReference = FirebaseDatabase.getInstance().getReference()
    .child("fbuserinfo");

    ValueEventListener valueEventListener = new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
          User user = ds.getValue(User.class);
          Log.d("User", user);
        }
      }
    }

    @Override
    public void onCancelled (DatabaseError databaseError){
      Log.d(TAG, "Error fetching user data - " + databaseError.getMessage());
    }
  }
userDataReference.addListenerForSingleValueEvent(eventListener);