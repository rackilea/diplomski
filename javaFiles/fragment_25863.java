public void fillDriverList(SnapshotListener listener) {

        //Creating firebase object
        Firebase ref = new Firebase(Config.FIREBASE_URL);   

        //adding a value event listener so if data in database changes it does in textview also not needed at the minute
        ref.child("Driver").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                arrayLat = new ArrayList<String>();

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Driver d = postSnapshot.getValue(Driver.class);

                    System.out.println("data snapshot Drivers name is -------------------> "+d.getName());

                    arrayLat.add(Double.toString(d.getLat()));


                }
                if(listener != null){
                    listener.onListFilled(arrayLat);
                }

            }

            /************had to implement this method****************/
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
             if(listener != null){
                    listener.onFailure();
                }
            }
        }); 

    }