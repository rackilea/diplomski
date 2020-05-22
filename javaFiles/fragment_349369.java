submit=(Button) findViewById(R.id.submit);
submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Map map = new HashMap();
        map.put("time", ServerValue.TIMESTAMP);
        myRef.push().setValue(map);
    }