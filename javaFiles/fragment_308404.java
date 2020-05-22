btnDone1 = (Button) findViewById(R.id.btnDone1);
calendar1.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
    @Override
    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){
        btnDone1.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                String date1 = dayOfMonth + "/" + (month + 1) + "/" + year;
                Intent doneD = new Intent(RentStartActivity.this, SearchActivity.class);
                doneD.putExtra("Date1", date1);
                startActivity(doneD);
            }
        });
    }
});