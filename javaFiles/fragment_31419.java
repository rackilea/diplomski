UserDatabaseref.addChildEventListener(new ChildEventListener()
     {
         @Override
         public void onChildAdded(DataSnapshot dataSnapshot, String s) {

          Users details =  dataSnapshot.getValue(Users.class);
        If(dataSnapshot.getKey().equals(FirebaseUserLoggedIn.getUid())){
                UserDetails.add(details);
       }
        Collections.reverse(UserDetails);
        Uviewholder = new UsersViewHolder(mydetails.this,UserDetails);
        PopulateListView.setAdapter(Uviewholder);
        Uviewholder.notifyDataSetChanged();

    }