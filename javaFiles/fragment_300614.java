@SuppressLint("ValidFragment")
public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    EditText txtDate;
    String strdate;
    DatePickerListener datePickerListener;
    @SuppressLint("ValidFragment")
    public DatePicker(View v, DatePickerListener _datePickerListener){
        txtDate = (EditText)v;
        this.datePickerListener = _datePickerListener;
    }

    public DatePicker() {

    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yyyy");
        strdate = simpleformat.format(c.getTime());
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int i, int i1, int i2) {

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        datePickerListener.onDatePickerDismissed();
        super.onDismiss(dialog);
    }
}