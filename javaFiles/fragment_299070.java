myRef.child("Scenes").child("Scene").addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                   for (DataSnapshot children : dataSnapshot.getChildren()) {
                       for (DataSnapshot child : children.getChildren()) {
                           //Log.v("key1","   " + child.getKey());
                           if(child.getKey().equals("Thumb")){
                               for (DataSnapshot child2 : child.getChildren()) {
                                   //Log.v("key2","   " + child2.getValue(String.class));
                                   for (DataSnapshot child3 : child2.getChildren()) {
                                       //Log.v("key3","   " + child3.getKey());
                                       if(child3.getKey().equals("LongUrl")){
                                           Log.v("key4","   " + child3.getValue(String.class));
                                            thumbUrl.add(child3.getValue().toString());
                                       }
                                   }
                               }
                           }
                       }

                       Log.v("keyResult","   " + thumbUrl);
                      // Log.v("key2","   " + thumbUrl);
                   }
               }

               @Override
               public void onCancelled(DatabaseError databaseError) {

               }
           });