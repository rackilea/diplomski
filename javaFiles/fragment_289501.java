public void getData(){
    databaseReference.child("User_table").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            final List<User> list = new ArrayList<>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                User user = snapshot.getValue(User.class);
                list.add(user);
            }
            displayData(list);
        }
        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        // Handle error here
        }
    });
}

@Override
public void displayData(List<User> list) {
    Adapter adapter= new Adapter(list, new Adapter.OnItemClickListener() {
        @Override
        public void onClickItem(User user) {
            presenter.clickItem(user);
        }
    });
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
}