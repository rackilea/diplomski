b1.setOnClickListener(new Button.OnClickListener(){

        @Override
        public void onClick(View v) {

             setContentView(R.layout.activity_main_activity2); 
             button = (Button) findViewById(R.id.button21);
             button.setOnClickListener(new Button.OnClickListener(){


        @Override
        public void onClick(View v) {
                             Toast.makeText(getBaseContext(),"Working",Toast.LENGTH_SHORT).show();         

}
    });              
        }
    });


or you can goto your other activity 

b1.setOnClickListener(new Button.OnClickListener(){

    @Override
    public void onClick(View v) {
       // setContentView(R.layout.activity_main_activity2); remove
          startActivity(new Intent(MainActivity.this,MainActivity2.class));
    }

});