final Button button1 = (Button)findViewById(R.id.button2);
    //Listeneři
    button1.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            button1.setText("ok");