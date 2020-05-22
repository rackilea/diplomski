Chronometer test = new Chronometer(this);
    start = (Button) findViewById(R.id.bStart);

    start.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
        //    com.example.chrono.Chronometer.start();
            test.start(); 
         } 
    });