String loggedInUserEmail = mAuth.getCurrentUser().getEmail();
String adminEmailAddress = "admin@admin.com";

if(loggedInUserEmail.equals(adminEmailAddress)) {
    finish();
    startActivity(new Intent(this, adminActivity.class));
} else {
    finish();
    startActivity(new Intent(this, ProfileActivity.class));
}