Button button1 = (Button) findViewById(R.id.button1);
    Button button2 = (Button) findViewById(R.id.button2);

    button1.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent("com.pttest.com.pockettankstips.release");
            Bundle b = new Bundle();
            b.putInt("index",1);  
            intent.putExtras(b); 
            startActivity(intent);
        }
    });


    button2.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent("com.pttest.com.pockettankstips.release");
            Bundle b = new Bundle();
            b.putInt("index",2);  
            intent.putExtras(b); 
            startActivity(intent);          
        }
    });