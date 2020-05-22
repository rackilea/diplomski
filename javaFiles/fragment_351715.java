public class TimePickerFragment extends DialogFragment {

    @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
        // ... omitted

        if (!(getActivity() instanceof OnTimeSetListener)) throw new IllegalStateException("Activity should implement OnTimeSetListener!");
        OnTimeSetListener timeSetListener =  (OnTimeSetListener) getActivity();

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), timeSetListener, hour, minute, false);
    }
}