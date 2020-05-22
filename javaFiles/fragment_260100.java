DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference coursesRef = rootRef.child("Courses");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<AllCourses> list = new ArrayList<>();
        for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
            for(DataSnapshot ds : dSnapshot.getChildren()) {
                AllCourses allCourses = ds.getValue(AllCourses.class);
                list.add(allCourses);
            }
        }

        //Do what you need to do with the list
        Log.d("TAG", list.size());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
coursesRef.addListenerForSingleValueEvent(valueEventListener);