public class Main3Activity extends AppCompatActivity implements DatePickerListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

.........

     //Initialise or create your dialog like this
      DatePicker dialog = new DatePicker(v,this);
}

@Override
    public void onDatePickerDismissed() {
         //Here You receive the dialog dissmiss listner
                        mGoogleMap.clear();
                        setMap(mGoogleMap);
    }
}