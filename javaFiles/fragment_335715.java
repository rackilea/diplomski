/*
 * Inside your Activity
 */
private Fragment fragment; // Store your fragment when you create it.

private void initializeCurrentUser(){
    /* .. */
    dbRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if(dataSnapshot != null){
                User u = dataSnapshot.getValue(User.class);
                Log.v("DSREF", "reached");
                setCurrentUser(u);
                ((MyFragment) fragment)).notifyLoaded();
            }
        }
        /* .. */
    });
}

/*
 * Inside your Fragment
 */
String email;

public void notifyLoaded() {
    // Do not call ((MainActivity)getActivity).getCurrentUser().getEmail() anywhere else in onCreate(View) etc..
    email = ((MainActivity)getActivity).getCurrentUser().getEmail();
    // Do things with non-null email now.
}