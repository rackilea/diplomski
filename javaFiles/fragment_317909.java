public class MainActivity extends Activity {


    LinearLayout myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (LinearLayout)findViewById(R.id.linearLayout);
        for(int i=0;i<5;i++) {

        final EditText myEditText = new EditText(MainActivity.this); // Pass it an Activity or Context
        //Stuff to make your edittext looks nice
        myEditText .setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { //When you click on the            
                // Process to get Current Time
                final Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(MainActivity.this, //same Activity Context like before
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                            int minute) {
                        myEditText.setText(hourOfDay + ":" + minute); //You set the time for the EditText created
                    }
                }, mHour, mMinute, false);
                tpd.show();

            }
        });
        myLayout.addView(myEditText);
        }
    }
}