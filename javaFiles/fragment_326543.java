yes = (Button) findViewById(R.id.finalYes);
    yes.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            Intent myIntent = new Intent(v.getContext(), Question13Activity.class);
            myIntent.putExtra("TestKey", "My new Text");
            startActivity(myIntent);
        }
    });