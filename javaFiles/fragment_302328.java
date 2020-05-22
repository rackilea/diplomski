firebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String[] resName = new String[(int) dataSnapshot.getChildrenCount()];
                String[] resLoc = new String[(int) dataSnapshot.getChildrenCount()];
                String[] resType = new String[(int) dataSnapshot.getChildrenCount()];
                int i = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    resName[i] = dataSnapshot1.child("resname").getValue().toString();
                    resLoc[i] = dataSnapshot1.child("resloc").getValue().toString();
                    resType[i] = dataSnapshot1.child("foodtype").getValue().toString();
                    Restau.add(new caloocanDB(resName[i], resLoc[i], R.drawable.six, resType[i]));
                    i++;
                }
        final MyListAdapter adapter = new MyListAdapter(Restau);
        ListView list = (ListView) findViewById(R.id.listViewRest);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });