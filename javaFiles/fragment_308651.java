public class DatePickerFragment extends DialogFragment implements OnDateSetListener {
    public class MyDatePickerDialog extends DatePickerDialog {
        private Calendar calendar;
        private final String format = "EEEE, MMMM dd, yyyy";

        // Regular constructor
        public MyDatePickerDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
            super(context, callBack, year, monthOfYear, dayOfMonth);
            calendar = Calendar.getInstance();
        }

        // Short constructor
        public MyDatePickerDialog(Context context, OnDateSetListener callBack, Calendar calendar) {
            super(context, callBack, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            this.calendar = calendar;
        }

        @Override
        public void onDateChanged(DatePicker view, int year, int month, int day) {
            super.onDateChanged(view, year, month, day);
            calendar.set(year, month, day);
            setTitle(DateFormat.format(format, calendar));
        }
    }

    private MyDatePickerDialog mDatePickerDialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDatePickerDialog = new MyDatePickerDialog(this, this, Calendar.getInstance());
        return mDatePickerDialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Log.v("DatePickerFragment", "onDateSet");
    }
}