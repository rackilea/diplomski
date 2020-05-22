public void sendMessage(View view) {
    Intent intent = new Intent(this, SecondActivity.class);
    String message = date.getText().toString();
    String message2 = date2.getText().toString();
    intent.putExtra(EXTRA_MESSAGE, message);
    intent.putExtra(EXTRA_MESSAGE_2, message2);
    startActivity(intent);
}