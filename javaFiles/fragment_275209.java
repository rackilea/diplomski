String passengerID = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users").child("Driver").child(driverFoundID).child("passengerRequest").child(passengerID);


            HashMap map = new HashMap();
            map.put("destination", destination);
            ref.updateChildren(map);