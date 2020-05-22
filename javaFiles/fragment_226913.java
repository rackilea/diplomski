showBookRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot data: dataSnapshot.getChildren()) {
            Book book = data.child("BookInfo").getValue(Book.class);
            bookList.add(book);
        }

        bookAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});