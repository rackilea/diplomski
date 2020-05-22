// Sample method of you launching PostActivity, I don't know your actual implementation
void sendUserToPostActivity() {
    Intent mIntent = new Intent(MainActivity.this, PostActivity.class);
    startActivity(mIntent);
    // finish() <-- Don't do that, so your MainActivity remains in the backstack
}