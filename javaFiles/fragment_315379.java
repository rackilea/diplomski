btnDone1 = (Button) findViewById(R.id.btnDone1);
btnDone1.setOnClickListener(new OnClickListener(){
    public void onClick(View v){
        Intent done = new Intent();
        done.putExtra("Date1", calendar1.getDate());
        done.putExtra("Time", time1.getDrawingTime());
        setResult(Activity.RESULT_OK,done);
        startActivity(done);
        finish();
    }
});