public class TimePickerFragment extends DialogFragment implements OnTimeSetListener {

    private int mId;
    private TimePickerDialogListener mListener;

    private static TimePickerFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt("picker_id", id);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
        // ... omitted

        mId = getArguments().getInt("picker_id");
        mListener = getActivity() instanceof TimePickerDialogListener ? (TimePickerDialogListener) getActivity() : null;

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute, false);
    }

    @Override public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        if (mListener != null) mListener.onTimeSet(mId, view, hourOfDay, minute);
    }

    public static interface TimePickerDialogListener {
        public void onTimeSet(int id, TimePicker view, int hourOfDay, int minute);
    }

}