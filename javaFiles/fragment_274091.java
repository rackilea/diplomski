DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference userInformationsRef = rootRef.child("userInformations");
String userInformationId = userInformationsRef.push().getKey();
String userInformationName = "spamemail0100@gmail.com";
UserInformation userInformation = new UserInformation(userInformationId, userInformationName);
userInformationsRef.child(userInformationId).setValue(userInformation);