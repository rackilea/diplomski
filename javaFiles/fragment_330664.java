private void logInValidator(String userName, SimpleCallback<Boolean> finishedCallback) {
// Everything stays the same in the method, but change your valueListener like this:

ValueEventListener valueEventListener = new ValueEventListener() {
@Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            user = ds.getValue(User.class);
        }
        String passHash = user.getPasswordHash();
        validated = false;
        try {
            validated = passwordHandler.validatePassword(password, passHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } finally {
            finishedCallback.run(validated); // send the result to the callback
        }
    }
    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d("error", databaseError.getMessage()); 
        finishedCallback.run(false); // send false return
    }
};
// this method is now void!
}