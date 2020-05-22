if (!error) {
    // user successfully logged in
    // Create login session
    session.setLogin(true);

    // Now store the user in SQLite
    String uid = jObj.getString("uid");

    JSONObject user = jObj.getJSONObject("user");
    String name = user.getString("name");
    String email = user.getString("email");
    String created_at = user.getString("created_at");

    // Save login name in the SharedPreferences here
    session.setLoginName(name);

    // Inserting row in users table
    db.addUser(name, email, uid, created_at);

    // Launch main activity
    Intent intent = new Intent(LoginActivity.this,
            MainActivity.class);
    startActivity(intent);
    finish();
}