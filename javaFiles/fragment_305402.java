public Dialog onCreateDialog(Bundle savedInstanceState) {
    // Use the current date as the default date in the picker
    final Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH); 


    //  Create a new instance of DatePickerDialog and return it
    DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month,day);
    Log.i("onCreateDialog", "onCreateDialog : MinDate() : "+new Date().getTime());

    Calendar cal=new GregorianCalendar();

    //min date
    dialog.getDatePicker().setMinDate(cal.getTime().getTime()-1000);
    Log.i("onCreateDialog", "onCreateDialog : MinDate() : "+cal.getTime());

    //max date .... added 30 days from currunt date
    cal.add(Calendar.DATE, 30);
    Date dte =cal.getTime();
    dialog.getDatePicker().setMaxDate(dte.getTime());
    Log.i("onCreateDialog", "onCreateDialog : MaxDate() : "+dte);

    //customizing calendar view
    dialog.getDatePicker().setCalendarViewShown(true);
    dialog.getDatePicker().setSpinnersShown(false);
    dialog.getDatePicker().getCalendarView().setShowWeekNumber(false);
    dialog.setCancelable(true);

    Log.i("Date", "date : "+System.currentTimeMillis());
    return dialog;
}