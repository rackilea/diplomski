System.out.println("Before attaching listener");
q.addChildEventListener(new ChildEventListener() {
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        System.out.println("In onChildAdded");    
    }
    public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
    public void onChildRemoved(DataSnapshot dataSnapshot) { }
    public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
    public void onCancelled(DatabaseError databaseError) { }
});
System.out.println("After attaching listener");