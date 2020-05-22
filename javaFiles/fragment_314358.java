Button crossButton = (Button) findViewById(R.id.crossImage)
Button button1 = (Button) findViewById(R.id.buttonOne)
//and so on

crossButton.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        button1.setVisibility(GONE);
        //and so on
    }
});