protected void onCreate(Bundle savedInstanceState) {  
  // TODO Auto-generated method stub  
  super.onCreate(savedInstanceState);
  userdate =(EditText) findViewById(R.id.user_datespent);
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
  Date da = new Date();
  userdate.setText( sdf.format(da));
  final Calendar cal = Calendar.getInstance();    

  final DatePickerDialog.OnDateSetListener datepickobj = new OnDateSetListener() {

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {
      // TODO Auto-generated method stub
      cday = dayOfMonth;
      cmonth = monthOfYear + 1;
      cyear = year;

      userdate.setText("Choosen date is :" + cday + "/" + cmonth + "/" + cyear);      
    }
  };

  Button changeDate = (Button) findViewById(R.id.button_for_cal);
  changeDate.setOnClickListener(new OnClickListener() {           
    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      DatePickerDialog(this, datepickobj,  cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 
                       cal.get(Calendar.DAY_OF_MONTH)).show();
      userdate.setText("");
    }
  });
}