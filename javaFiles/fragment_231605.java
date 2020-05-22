public class MainActivity extends Activity {


     int hour = -1, min = -1;
     static final int TIME_DIALOG_ID = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       EditText etOne = (EditText) findViewById(R.id.editText1);
        etOne.setOnClickListener(new EditText.OnClickListener() {
          public void onClick(View v) {
               // Do stuff here
              if (hour == -1 || min == -1) {
                  Calendar c = Calendar.getInstance();
                  hour = c.get(Calendar.HOUR);
                  min = c.get(Calendar.MINUTE);
             }

            showTimeDialog(v, hour, min);
        }
    });

}

public void showTimeDialog(View v, int hour, int min) {
    (new TimePickerDialog(MainActivity.this, timeSetListener, hour, min,
            true)).show();
}

public TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        hour = hourOfDay;
        min = minute;
        EditText et = (EditText) findViewById(R.id.editText1);
        et.setText(hour + " : " + min);

    }
  };
  }