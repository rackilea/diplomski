//in Activity
public void onCreate(Bundle bundle){
    super.onCreate(bundle);

    DatabaseHelper myDataBaseHelper = ...;//

    setContentView(R.layout.my_layout);
    Spinner spinner = (Spinner)findViewById(R.id.my_spinner);
    Util.populateStandardSpinner(myDataBaseHelper, spinner, 
        getApplicationContext());

    //...
}


//Another class
public class Util{
    public static void populateStandardSpinner(DatabaseHelper dbHelper, 
            Spinner spinner, Context context) {
        //Get cursor from dbHelper
        //Create adapter for cursor data and apply it to spinner
}