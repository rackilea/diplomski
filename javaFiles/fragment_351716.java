public class MainActivity extends FragmentActivity implements TimePickerDialog.OnTimeSetListener { 

    @Override public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.i("TimePicker", "Time picker set!");
    }
}