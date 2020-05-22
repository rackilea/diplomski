ParseUser currentUser = ParseUser.getCurrentUser();
if (currentUser != null) {
    Intent launchMainActivity = new Intent(this, SecondActivity.class);
    startActivity(launchMainActivity );
} else {
    ParseLoginBuilder builder = new ParseLoginBuilder(FirstActivity.this);
    startActivityForResult(builder.build(), 0);
}