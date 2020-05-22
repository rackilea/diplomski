public void setTextUsername(String username)
    this.textViewUsername.setText(username);
    //here you can do all you need with username value
}

public void loadUserNameFromFirestore(Appointment appointment){
    String userUid = appointment.getAppointment_doctor_uid();

    db.collection(Constants.FIRESTORE_DOCTOR).document(userUid)
        .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

    @Override
    public void onSuccess(@NonNull Task<DocumentSnapshot> task) {
        StringBuilder userFullName = new StringBuilder();
        DocumentSnapshot documentSnapshot = task.getResult();
        userFullName.append(documentSnapshot.getString(Constants.FIRESTORE_STAFF_TITLE)).append(" ");
        userFullName.append(documentSnapshot.getString(Constants.FIRESTORE_STAFF_FNAME)).append(" ");
        userFullName.append(documentSnapshot.getString(Constants.FIRESTORE_STAFF_LNAME));
        Log.d("DEBUG_APP", userFullName.toString());
        setTextUsername(userFullName.toString());
    }})
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
}