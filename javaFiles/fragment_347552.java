public class DialogFragmentTimePicker extends DialogFragment implements OnTimeSetListener {

public static final String ARG_HOUR = "hour";

public static final String ARG_MINUTE = "minute";

private OnTimeSetListener mListener;

@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    // Use the current time as the default values for the picker
    int hour, minute;
    if (getArguments() != null) {
        hour = getArguments().getInt(ARG_HOUR);
        minute = getArguments().getInt(ARG_MINUTE);
    } else {
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
    }

    // Create a new instance of TimePickerDialog and return it
    return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
}

public void setOnTimeSetListener(OnTimeSetListener listener) {

    mListener = listener;
}

public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    if (mListener != null) {
        mListener.onTimeSet(view, hourOfDay, minute);
    }
}