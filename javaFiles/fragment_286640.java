FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(); 
DatabaseReference driver = FirebaseDatabase.getInstance().getReference().child("Drivers"); 
DatabaseReference rider = FirebaseDatabase.getInstance().getReference().child("Riders");

  if (user != null) {
    driver.child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() { 
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) { 
                    Intent i = new Intent(SplashActivity.this, DriverHomeActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, RiderHomeActivity.class);
                    startActivity(intent);
                    finish();
                  }
            @Override
          public void onCancelled(DatabaseError databaseError) {

               }
           });