private int notaps;

    Button tapb = (Button)findViewById(R.id.tapb);
    Button reset = (Button)findViewById(R.id.reset);
    TextView taps = (TextView)findViewById(R.id.taps);

    tapb.setOnClickListener(
        new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                notaps++;
                taps.setText(String.valueOf(notaps));
            }
        }
    );

    reset.setOnClickListener(
        new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaps = 0;
                taps.setText(String.valueOf(notaps));
            }
        }
    );