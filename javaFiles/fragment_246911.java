public void sendMessage(View v) {

    EditText mEdit = (EditText) findViewById(R.id.editText);
    String feedMsg = mEdit.getText().toString();
    if (feedMsg.equals("")) {
        // Do not send the message
    } else {
        View linLayout = findViewById(R.id.linLayout);

        TextView newMsg = new TextView(this);

        newMsg.setText("Player just created a group called " + feedMsg + "!\n" + getDate());
        newMsg.setId(5);
        newMsg.setTextSize(20);
        newMsg.setBackgroundColor(Color.parseColor("#F655F080"));
        newMsg.setPadding(20, 20, 20, 20);
        newMsg.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        ((LinearLayout) linLayout).addView(newMsg);
        mEdit.setText(""); // Clears the text
        hideSoftKeyboard(MainActivity.this); // Hides the keyboard

        Toast msgToast = Toast.makeText(getApplicationContext(), "Message sent!", Toast.LENGTH_SHORT);
        msgToast.show(); // Shows the notification about the successful message
    }

}