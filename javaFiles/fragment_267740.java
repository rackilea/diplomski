// Attach a listener to read the data at our database 
    mDatabase.child("hopitaux").addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot snapshot : dataSnapshot.getChildren())
         {
             //this will get all the timeStamps keys of your database
            long timestamps = snapshot.getKey();

            //if you want to get all the values inside each key you should make a Bean with the data that you want to request, i understand that Marker.class is your object with all your getters so 
              Marker mark = snapshot.getValue(Marker.class);
              Map<String, Marker> markers = new HashMap();
              markers.put("lat",mark.getLat());
              markers.put("lng",mark.getLng()); //and so on..

           }

      }

      @Override
      public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
      }
    });