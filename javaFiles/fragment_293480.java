FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
DatabaseReference databaseReference = firebaseDatabase.getReference("Locations"); 
//Instead of "Locations" you can say something else. Locations will be the name of your path where the location is stored.
//Create a Hashmap to store the information with a key and a value:
Hashmap<String, String> values = new Hashmap<>();
values.put("Location", city);
databaseReference.push().setValue(values);