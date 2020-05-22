DocumentReference mFirestoreProfiles = mFirestore.collection("profiles").document(currentuser);
Profile profile = new Profile(email, birth);
mFirestoreProfiles.set(profile).addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {
        Toast.makeText(getApplicationContext(), "Document written successfully!", Toast.LENGTH_SHORT).show();
    }
});