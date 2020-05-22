ref.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot snapshot) {
          System.out.println("There are " + snapshot.getChildrenCount() + " chapters");
          for (DataSnapshot chapterSnapshot: snapshot.getChildren()) {
            Chapter chapter = chapterSnapshot.getValue(Chapter.class);
            // Get your chapter details here.
          }
      }
      @Override
      public void onCancelled(FirebaseError firebaseError) {
          System.out.println("The read failed: " + firebaseError.getMessage());
      }
  });