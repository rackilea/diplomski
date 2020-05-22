boolean isUserCreated = false;
mFirebaseDatabase....addValueEventListener(new ValueEventListener() {            

@Override
public void onDataChange(...) {
    if (dataSnapshot.getValue() == null) {
        if (TextUtils.isEmpty(userId)) {
            isUserCreated = true;
            createUser(...) 
         }
     } else if (!isUserCreated) {
         Toast.makeText(Register.this, "User already Registered", Toast.LENGTH_SHORT).show();
     }
 }
... 
});