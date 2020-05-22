private void login() {
    ...
    // User was authenticated successfully
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        UserSchema user = snapshot.getValue(UserSchema.class);

        // store the user's name and email with our SharedPreferences
        editor.putString("name", user.getName());
        editor.putString("email", user.getEmail());
        editor.apply();

        // Start the MainActivity
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    } 
}