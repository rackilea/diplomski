public void customAlertDialog(){

final Dialog dialog = new Dialog(HesapActivity.this);
    dialog.setContentView(R.layout.dateset);
    dialog.setTitle("Date");
    theInflatedView = getLayoutInflater().inflate(R.layout.dateset, null);
    final DatePicker dpFirst = (DatePicker) theInflatedView.findViewById(R.id.datePicker1);
    final str;
    dpFirst.init(dpFirst.getYear(), dpFirst.getMonth(), dpFirst.getDayOfMonth(),new OnDateChangedListener() {

         @Override
         public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
         str=(arg3+ "."+ (arg2+1) + "."+arg1);
         }
         } );

    Button dialogButton = (Button) dialog.findViewById(R.id.setDPBt);
    dialogButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {       
            textFirst.setText(str);//textFirst is MainActivity variable.
            dialog.dismiss();
        }
    });

    dialog.show();


  }