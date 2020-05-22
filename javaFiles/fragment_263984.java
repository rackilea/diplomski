firebaseAuth = FirebaseAuth.getInstance ();
final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
String user_id = "";

if(firebaseUser != null)
    user_id = firebaseUser.getUid ();