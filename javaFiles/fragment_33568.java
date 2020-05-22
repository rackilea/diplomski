textview1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fromWhere="textview1";
                showDialog(TIME_DIALOG_ID);
            }
    });

    textview2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fromWhere="textview2";
                showDialog(TIME_DIALOG_ID);
            }
    });
    ...
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(android.widget.TimePicker view,
                        int hourOfDay, int minute) {

                    if(fromWhere.equals(textview1))
                           // set hour and minute to according variable and textview
                    else if(fromWhere.equals(textview2))
                           // set hour and minute to according variable and textview
                    .. //so on for others
                    //mHour = hourOfDay;
                    //mMinute = minute;
                    fromWhere="";
                }
    };