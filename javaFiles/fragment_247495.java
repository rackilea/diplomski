private void getAssignedPassenger() {
    String driverID = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users").child("Driver").child(driverID).child("passengerRequest");
    ref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                List<String> passengerIdList = new ArrayList()
                for (DataSnapshot passenger Snapshot: dataSnapshot.getChildren()) {
                    String passengerId = passenger.getKey()
                    passengerIdList.add(passengerId)
                }
                getAssignPassengerPickUpLocation();
            }else{
                passengerID = "";
                if(pickupMarker !=null){
                    pickupMarker.remove();
                }
                if(AssignPassengerPickupLocationListener!= null){
                AssignPassengerPickupLocationref.removeEventListener(AssignPassengerPickupLocationListener);
            }}
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
}