FirebaseDatabase.getInstance().getReference().child("chats").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                  String key = ds.getKey();
                  if(key.contains("Doc Ahmed Rafaat to Pat Ahmed El-Nakib")
                   {
                      String doctorName = key.subString(4,16);
                      allDoctorsModels.add(new AllDoctorsModel(doctorName, "", ""));
                   }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });