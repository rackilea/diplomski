public CursorAdapter myCursorAdapter;

@Override
public void onCreate(Bundle savedInstanceState) {
    //... all your stuff
    myCursorAdapter = new CursorAdapter(this, getAppointmentsData());
}