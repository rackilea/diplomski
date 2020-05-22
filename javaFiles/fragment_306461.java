mDatabase.child("User").child(uid).child("Database").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot Snapshot) {
                list.clear();

                    Item item = dataSnapshot.getValue(Item.class);

                    list.add(item);

                Collections.sort(list, (l1, l2) -> l1.getNama().compareTo(l2.getNama())); //buat sort alphabetically
                itemAdapter = new ItemAdapter(MainActivity.this, list);
                recyclerView.setAdapter(itemAdapter);
                progressDialog.dismiss();
            }