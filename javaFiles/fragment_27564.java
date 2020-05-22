public class TimePickerFragment extends DialogFragment
implements TimePickerDialog.OnTimeSetListener {
    public interface PickTime
    {
        public void returnTime(String value);

    }

    PickTime mCallback;
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current time as the default values for the picker
    mCallback = (PickTime) getActivity();
final Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY);
int minute = c.get(Calendar.MINUTE);

// Create a new instance of TimePickerDialog and return it
return new TimePickerDialog(getActivity(), this, hour, minute,
DateFormat.is24HourFormat(getActivity()));
}

public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
// Do something with the time chosen by the user

    if(mCallback!=null)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(hourOfDay);
        sb.append(":");
        sb.append(minute);
        mCallback.returnTime(sb.toString());
    }
}
}