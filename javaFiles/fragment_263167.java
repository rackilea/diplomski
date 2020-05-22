saveButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String user_id = mAuth.getCurrentUser().getUid();
        DatabaseReference current_user_db = mDatabase.child(user_id);

        if(mFirstCheckBox.isChecked()) {
            current_user_db.child("1").setValue("Compiler design");
        }

        if(mSecondCheckBox.isChecked()) {
            current_user_db.child("2").setValue("Operating Systems");
        }

        if(mThirdCheckBox.isChecked()) {
            current_user_db.child("3").setValue("Software Engineering");
        }

        Intent interestIntent = new Intent(HomeActivity.this, InterestsActivity.class);
        interestIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(interestIntent);
    }
});