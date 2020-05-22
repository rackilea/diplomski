date.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Date_Alert(v);
                    return true;
                }

                private void Date_Alert(View v)
                {

    getActivity().getWindow().setSoftInputMode(
        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
    );                
    DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //date_str = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        mYear = year;
                        mMonth = monthOfYear;
                        mDay = dayOfMonth;
                        mMonthName = MONTHS[monthOfYear];
                        Log.d("before", "onDateSet: " + mYear + "" + mMonthName + "" + mDay);
                        start_date_str = mDay + " " + mMonthName + " " + mYear;

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
}