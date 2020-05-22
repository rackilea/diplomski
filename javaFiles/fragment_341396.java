btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.d("My app","Button is pressed");
        Toast.makeText(MainActivity.this,"Button pressed",Toast.LENGTH_SHORT).show();
        sendMessage(v); //Or anywhere in that method, your call.
    }
});