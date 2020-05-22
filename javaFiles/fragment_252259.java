ab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);

        }

    });
    ba=(Button)findViewById(R.id.button);



    ba.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                   Intent intentt = new Intent(MainActivity.this, Main6Activity.class);
                    startActivity(intentt);


            }

    });