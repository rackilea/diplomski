MainActivity mainActivity = (MainActivity) myContext;
    final DatePickerDialog dpd = DatePickerDialog.newInstance(
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                    //To do your task here
                }
            },
            mYear,
            mMonth,
            mDay
    );
    dpd.setVersion(DatePickerDialog.Version.VERSION_2);
    dpd.setMaxDate(Calendar.getInstance());
    dpd.show(mainActivity.getFragmentManager(), "Datepickerdialog");