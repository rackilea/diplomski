final Button b = (Button) findViewById(R.id.clockout);
    b.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            if(go == 1)
                go = 0;
            if (t != null){
                t.cancel();
                cd.cancel();
            }
            }