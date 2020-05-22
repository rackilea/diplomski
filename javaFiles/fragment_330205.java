public static class AppDatePickerDialog extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

    private int mYear, mMonth, mDay;
    private String sMonth;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), this, mYear, mMonth, mDay);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //you logic to set the field to true or false
    }
}