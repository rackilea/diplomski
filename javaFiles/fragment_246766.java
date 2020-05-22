OnCompleteListener<AuthResult> completeListener = new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            boolean isNewUser = task.getResult().getAdditionalUserInfo().isNewUser();
            if (isNewUser) {
                Log.d("TAG", "Is New User!");
            } else {
                Log.d("TAG", "Is Old User!");
            }
        }
    }
};