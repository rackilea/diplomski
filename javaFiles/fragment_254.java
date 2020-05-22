{
 //inside your activity on create scope  
 int dateData=0;
 int monthData=0; 
 int yearData=0;  
 calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
            dateData= i2;
            monthData= i1;
            yearData= i;


//Log here whether u getting date here?
        }
    });


public void onClick(View view) {

    if(view == buttonGetDate1) {

       Bundle localBundle = new Bundle();
       localBundle.putInt("Date", dateData);
       localBundle.putInt("Month", monthData);
       localBundle.putInt("Year", yearData); 


        Intent localIntent = new Intent(MainActivity.this, TestActivity.class);
        localIntent.putExtras(localBundle);
        startActivity(localIntent);
        finish();

    }
  }
}//Activity scope ends