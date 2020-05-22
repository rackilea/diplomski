Intent intent = getIntent();
    String data = intent.getStringExtra("data");


    if (data.equals("button1")){
        setContentView(R.layout.layout1);
    }
    if (value.equals("button2")){
        setContentView(R.layout.layout2);
    }