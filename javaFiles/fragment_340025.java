DatabaseReference userData = mdatabase.child(userid);
userData.child("email").setValue(getUserEmail());
userData.child( "id" ).setValue( firebaseUser.getUid() );
userData.child( "likescount" ).setValue( "0" );
userData.child( "username" ).setValue( "put your name" );
userData.child( "photoUrl" ).setValue( "C:\\Users\\Ameer Alnajm\\Desktop\\BOC\\app\\src\\main\\res\\drawable\\facebooklike_websitepng.png" );