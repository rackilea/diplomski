TextView date1=(TextView)findViewById(R.id.tvdatetime);
    time1=(TextView)findViewById(R.id.tvtime);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    dt1 = sdf.format(new Date());
    // textView is the TextView view that should display it
    date1.setText(dt1);
    datevalue=date1.getText().toString();
    //Shows Current time 
    Time today = new Time(Time.getCurrentTimezone());
    today.setToNow();
    time1.setText(today.format("%k:%M:%S"));
    timevalue=time1.getText().toString();