private void showFromDatePicker(DatePickerDialog.OnDateSetListener listener,
                                Calendar calendar,
                                Calendar minDateCalender) {
        DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        if (minDateCalender != null) {
            dialog.getDatePicker().setMinDate(minDateCalender.getTimeInMillis());
        }
        dialog.show();
    }

private void showToDatePicker(DatePickerDialog.OnDateSetListener listener,
                                Calendar calendar,
                                Calendar maxDateCalender) {
        DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
       dialog.getDatePicker().setMaxDate(maxDateCalender.getTimeInMillis());

        dialog.show();
    }