TextView text = (TextView) findViewById(R.id.textview); // change with your TextView id
text.setText("Goodbye World");
Button btn = (Button) findViewById(R.id.button); // change with your button id
btn.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        text.setText("Hello World");
    }
});