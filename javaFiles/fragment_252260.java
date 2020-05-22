ab=(Button)findViewById(R.id.button2);
    final Intent intent= new Intent();
    intent.setClass(MainActivity.this, Main2Activity.class);

    ab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            startActivity(intent);

        }

    });
    ba=(Button)findViewById(R.id.button);
    final Intent intentt= new Intent();
    intentt.setClass(MainActivity.this, Main6Activity.class);

    ba.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


                    startActivity(intentt);


            }

    });