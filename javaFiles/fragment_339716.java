Button button1 = (Button) findViewById(R.id.button1);

button1.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0) 
            {   Intent i = new Intent(getApplicationContext(),GoogleDocsLogin.class);
    startActivity(i);

}   };