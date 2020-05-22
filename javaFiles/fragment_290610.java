songNames = new ArrayList<String>();

    mProfileDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot)Aft
        {

            mProfileDatabase.child(djName).child("song")
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            List<String> sArr = new ArrayList<String>();
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                sArr.add(snapshot.getValue(String.class));
                            }

                            LinkedHashMap<String, Integer> songCounts = new LinkedHashMap<>();
                            for(int i = 0; i < sArr.size(); i++)
                            {
                                String eachSong = sArr.get(i);
                                if(songCounts.containsKey(eachSong))
                                {
                                    int count = songCounts.get(eachSong);
                                    songCounts.put(eachSong, count + 1);
                                }
                                else
                                {
                                    songCounts.put(eachSong, 1);
                                }
                            }
                            ArrayList<POJO> arrayList = new ArrayList<>();
                            for(Map.Entry<String,Integer> s:songCounts.entrySet()){
                                POJO pojo = new POJO(s.getKey(),s.getValue());
                                arrayList.add(pojo);
                            }

                            CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(DjLanding.this,arrayList);
                            recyclerView.setAdapter(adapter);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
        }


        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });