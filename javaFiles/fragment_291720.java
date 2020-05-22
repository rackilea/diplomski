@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.New_Activity_That_User_Has_No_Control_Of);

/////////////////////////////////////////////////////////////////////////

Intent i = new Intent(NewActivityThatUserHasNoControlOf.this, ThirdAndFinal.class);
    startActivity(i)