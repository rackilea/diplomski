public class CreateAppointment extends Activity implements OnClickListener{

    EditText nameTextBox;
    EditText timeTextBox;
    EditText detailsTextBox;
    Button createButton;
    Date date = new Date();
    Appointment getNewID;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);

        createButton = (Button) findViewById(R.id.apptSave);
        nameTextBox = (EditText)findViewById(R.id.apptName);//Assign the global name box
        timeTextBox = (EditText)findViewById(R.id.apptTime);//Assign the global time box
        detailsTextBox = (EditText)findViewById(R.id.apptDetails);//Assign the global details box

       String getNewDate = date.toString();
       String getNewTitle = nameTextBox.getText().toString();
       String getNewTime = timeTextBox.getText().toString();
       String getNewDetails = detailsTextBox.getText().toString();

        createButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId()){

        case R.id.apptSave:
            DBHandler db = new DBHandler(this);
            db.addAppointment(new Appointment(getNewID.getID(), getNewDate, getNewTitle, getNewTime, getNewDetails));
            finish();
            break;
        }
    }
}