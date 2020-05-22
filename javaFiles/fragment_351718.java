public class MainActivity extends FragmentActivity implements TimePickerFragment.TimePickerDialogListener { 

    private static final int START_TIME_PICKER_ID = 1;
    private static final int END_TIME_PICKER_ID = 2;

    public void InputStartTime(View v) {
        // supply the appropriate id - I'm assuming you'll be adding an InputEndTime method somewhere that will then supply END_TIME_PICKER_ID 
        DialogFragment newFragment = TimePickerFragment.newInstance(START_TIME_PICKER_ID);
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @Override public void onTimeSet(int id, TimePicker view, int hourOfDay, int minute) {
        Log.i("TimePicker", "Time picker set from id " + id + "!");

        // here you can compare the id value to figure out what picker this data came from
    }
}