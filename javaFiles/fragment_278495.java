private boolean check_data(final String User, final String pwd) {

    for (DataSnapshot postSnapshot : myDataSnapshot.getChildren()) {
        Log.d(TAG,"Data_of_post:" + postSnapshot.child("User").getValue());
        if (postSnapshot.child("User").getValue().toString().equals(User)
                && postSnapshot.child("Passwort").getValue().toString().equals( pwd)){
            Log.d(TAG,"arrived?");
            setstatus();
        }
        else{
            Log.d(TAG,"Data_of_post_comparison:" + postSnapshot.child("User").getValue() + " " + User + "next" + postSnapshot.child("Passwort").getValue()+ " " + pwd);
        }

    }

    Log.d(TAG,"status_of_boolean" + status);
    return status;
}