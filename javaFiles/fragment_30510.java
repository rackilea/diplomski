if(task.isSuccessful() && (loggedInUserEmail.equals(adminEmailAddress))) {
    finish(); // finish activity
    Intent intent = new Intent(MainActivity.this, adminActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
} else {
    finish(); // finish activity
    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
}