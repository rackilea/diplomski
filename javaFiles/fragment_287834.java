@NonNull
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    Calendar c = Calendar.getInstance();
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
    return new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
        @Override
        public onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // TODO : implement the functionality
        }
    }, hour, minute, DateFormat.is24HourFormat(getActivity()));
}