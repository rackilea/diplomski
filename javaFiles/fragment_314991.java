private void updateYourActivity(Context context) {

    Intent intent = new Intent("some_unique_name");

    // put whatever data you want to send, if any
    // intent.putExtra("message", message);

    // send broadcast
    context.sendBroadcast(intent);
}