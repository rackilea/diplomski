Date minDate = new Date(1990, 10, 25);
Date maxDate = new Date(2013, 4, 15);



OnDateChangedListener listener = new OnDateChangedListener() {

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear,
            int dayOfMonth) {

        Date current = new Date(year, monthOfYear, dayOfMonth);

        if( current.getTime() < minDate.getTime() )
        {
            //set to minimum date
        }else if( current.getTime() > maxDate.getTime() )
        {
            //Set to max Date
        }

    }
};
YourDatePicker.init(2013, 4, 15, listener);