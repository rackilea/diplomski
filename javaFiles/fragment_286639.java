FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Drivers").child(user.getUid());
ref.child("name").setValue(name);
Intent startIntent = new Intent(MainActivity.this,DriverHomeActivity.class);
startActivity(startIntent);
finish();