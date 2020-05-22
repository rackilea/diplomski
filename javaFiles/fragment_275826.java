final DatabaseReference playersDB = FirebaseDatabase.getInstance().getReference()
            .child("Rooms") // end here if you want to listen to all rooms
            .child(roomId)  // end here if you want to listen to THIS room
            .child("Players"); // I end here because I only want players' data
playersDB.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot ds) {
         // update UI here;
         }
 }