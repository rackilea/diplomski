fromAPU.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot apuToVistaSnapshot) {
                for (DataSnapshot scheduleSnapshot : apuToVistaSnapshot.getChildren()){
                    String key  = scheduleSnapshot.getKey();
                    // Do whatever you want with this key
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });