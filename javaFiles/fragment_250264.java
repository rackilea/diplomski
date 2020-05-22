Button page1 = (Button) findViewById(R.id.Button01);
page1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        Intent myIntent = new Intent(getContext(), DroidzActivity.class); // fix View.getContext() to getContext()
        startActivity(myIntent);    // change to startActivity
    }
});