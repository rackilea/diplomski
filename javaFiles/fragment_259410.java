Button addButton= (Button) findViewById(R.id.add_button);
addButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Edittext et= new Edittext(your_activity_name.this); //Replace with your activity name
       ll.addView(et);
    }
});