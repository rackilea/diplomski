int number_item_load = 10; //changed number if you want
    public void loadMore(int offset, String theLastValue) {
        // theLastValue: depend on your orderByChild() 's value
        mDatabase = FirebaseDatabase.getInstance().getReference().child(Utils.FB_ROOT);
        mEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if (isAlreadyAttach()) {
                    // Get your item and callback to view and insert to listView
                }
            } ...
        };


        mDatabase.orderByChild("yourvalue").startAt(theLastValue).limitToFirst(number_item_load ).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // TODO Finished loaded number_item_load  item
                OnLoadedFinish(); // 
                mDatabase.removeEventListener(mEventListener); // Remove listener after load
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase.orderByChild("yourvalue").startAt(theLastValue).limitToFirst(number_item_load ).addChildEventListener(mEventListener);
    }