Button  button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), Activity1.class);
                startActivity(intent);

            }

        });

        Button  button1 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener(){ 
              @Override
              public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), Web.class);
                startActivity(intent);
              }

            });