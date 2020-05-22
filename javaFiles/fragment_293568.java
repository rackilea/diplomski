@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
    if (documentSnapshot.exists()) {
        String name = documentSnapshot.getString(ARG_Firebase_User_Name);
        String surname = documentSnapshot.getString(ARG_Firebase_User_SurName);
        listener.onValueReady(name, surname);
        Log.d(TAG, "onSuccess: " + name + " " + surname);
    } else {
        Log.d(TAG, "onSuccess: but not exist");
    }

}