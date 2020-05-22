OnDateChangedListener listener = new OnDateChangedListener() {

        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
        }
    };
    date.init(prefs.getInt("year",1920),prefs.getInt("month",0),prefs.getInt("day",1),listener);