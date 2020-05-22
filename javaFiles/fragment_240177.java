button1 = (Button) findViewById(R.id.button1);
button1.setText(move.cups.get(0).toString());
button1.setOnClickListener(new Button.OnClickListener() {
    public void onClick(View v) {
        move.makeMove(move.cups.get(0));
        button1.setText(move.cups.get(0).toString()); //or whatever you want to display in the button after each click
    }
});