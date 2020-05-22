database = FirebaseDatabase.getInstance();
ref1 = database.getReference("requests");
DatabaseReference ref2=ref1.push();
String id=ref2.getKey();
request1 =new requests();
ref1.child(id).setValue(request1);
//some code may be missing