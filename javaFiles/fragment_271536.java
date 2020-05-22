DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference(); //get the reference to your database
User user = new User ();
user.setEmail(emailString);
user.setPassword(passwordString);
String yourKey = dbRef.child("users").push().getKey(); //get the key
dbRef.child("users").child(yourKey).setValue(user); //insert user in that node