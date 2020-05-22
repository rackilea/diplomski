private void fetchBookList() {
        progressDialog();

        //---Your Reference to the bookList---\\
DatabaseReference dbRefQuoteRequestList = firebaseDatabase.getReference("All_Orders").child("Anthony Hopkins")
                .child("orders").child("bookList");
        dbRefQuoteRequestList.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(final com.google.firebase.database.DataSnapshot dataSnapshot) {
                quoteRequestListArrayList.clear(); // ArrayList<Pojo/Object> \\

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    String bookName = postSnapshot.child("bookName").getValue(String.class);
                    //Use the dataType you are using and also use the reference of those childs inside arrays\\

                    // Putting Data into Getter Setter \\
                    BookList bookList = new BookList();
                    bookList.setbookName(bookName);

                    quoteRequestListArrayList.add(bookList);

                }

                if (quoteRequestListArrayList.size() == 0) {
                    StaticMethods.customSnackBar(quoteRequestLv, "Your alert!",
                            getResources().getColor(R.color.colorPrimaryDark),
                            getResources().getColor(R.color.color_white), 3000);
                }

                //---Initialize your adapter as you have fetched the data---\\
                quoteRequestListAdapter = new QuoteRequestListAdapter(QuoteRequestListActivity.this, quoteRequestListArrayList);
                quoteRequestLv.setAdapter(quoteRequestListAdapter);

                dismissDialog();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }