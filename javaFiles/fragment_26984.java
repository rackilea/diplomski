public DatePickerDialog.OnDateSetListener fromdateListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    calFromDate.set(year, monthOfYear, dayOfMonth);
                    selectedFromDate = returnFormattedDate(calFromDate.getTimeInMillis());
                    textviewFrom.setText(selectedFromDate);
                }
            };

    DatePickerDialog.OnDateSetListener todateListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    calToDate.set(year, monthOfYear, dayOfMonth);
                    selectedToDate = returnFormattedDate(calToDate.getTimeInMillis());
                    textviewTo.setText(selectedToDate);
                }
};
private  String returnFormattedDate(long timeInMilliSec) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",
                Locale.getDefault());
        return dateFormat.format(new Date(timeInMilliSec));
}