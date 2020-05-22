ChildEventListener childEventListener = new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
        Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

        // A new device has been added, add it to the list
       Device device = deviceSnapshot.getValue(Device.class);
            //Add the fetched data into the local list.
       devices.add(device);
       // notify your adapter about data change
       updateLatestDistance(dataSnapshot.getKey(), device.la, device.lo);
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
        Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());

        //get device from list using device id for example. set the updated to the item in device list. notify
        updateLatestDistance(dataSnapshot.getKey(), device.la, device.lo);

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());

        // remove device from the list, notify adapter.
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
        Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w(TAG, "postComments:onCancelled", databaseError.toException());
}};