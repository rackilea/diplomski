Button clickButton = (Button) findViewById(R.id.clickButton);
clickButton.setOnClickListener( new OnClickListener() { 
    @Override 
     public void onClick(View v) { 
        new getData().execute();
     } 
});