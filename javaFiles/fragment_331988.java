public void sendMessage(View view) {
    Log.w("msg", "user click");

    Intent intent = new Intent(this, DisplayMessageActivity.class);
    startActivity(intent);
}