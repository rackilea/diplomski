// For all players, listen to the ref in onCreate() of an Activity.
    onCreate(...){
            ...
            cgRef.addValueEventListener(new ValueEventListener() {
                // update UI in onDataChange()
                // maybe you wand to update your list then adapter.notifyDatasetChanged()
            }
    }

// For creator, write the game's data when the game created.
    createGame(...){
        cgRef.child("someName").setValue(someData);
    }