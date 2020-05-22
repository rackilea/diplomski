public class SpinnerDatePickerDialog extends DialogFragment {

    private ISpinnerDatePickerDialogListener listener;
    private DatePicker datePicker;

    // this is no clean android fragment constructor, but we want to use it here
    @SuppressLint("ValidFragment")
    public SpinnerDatePickerDialog(ISpinnerDatePickerDialogListener listener) {
        super();
        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);
        datePicker = (DatePicker) view.findViewById(R.id.spinnerDatePicker);
        datePicker.updateDate(defaultYear, defaultMonth, defaultDay);
        builder.setView(view);
        builder
            .setPositiveButton(R.string.submit, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Send the positive button event back to the host activity
                    listener.onSpinnerDateDialogPositiveClick(SpinnerDatePickerDialog.this);
                }
            })
            .setNegativeButton(R.string.abort, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Send the negative button event back to the host activity
                    listener.onSpinnerDateDialogNegativeClick(SpinnerDatePickerDialog.this);
                }
            });
        return builder.create();
    }

}