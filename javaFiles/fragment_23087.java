MySQLiteOpenHelper myhlpr = new MySQLiteOpenhelper(this); // parms might be different
if (myhlpr.ifValidUserLogin(username_from_ui,password_from_ui)) {
    // username and password match so do what you need to do here!
} else {
    // mismatch so do what you need to do here!.
}