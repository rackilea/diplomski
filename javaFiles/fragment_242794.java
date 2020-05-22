@Override
protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.plan_activity );
}

@Override
public boolean onCreateOptionsMenu( Menu menu ) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate( R.menu.main, menu );
    return true;
}

@SuppressLint("NewApi")
public void adActivity( View view ) {    
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    View parentView  = inflater.inflate(R.layout.add_activity, null);
    LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(parentView);
           builder.setPositiveButton(R.string.add_activity, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   //Stert
               }
           })
           .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   dialog.cancel();
               }
           });
    fillArray(parentView);
    // Create the AlertDialog object and return it
    AlertDialog mainAlert = builder.create();
    mainAlert.show();

}

// Method to fill the NumberPicker's
public void fillArray(View view) {

    View inflatedView = view;
    np_hours = ( NumberPicker ) inflatedView.findViewById( R.id.hourNumber );
    np_hours.setMaxValue(24);
    np_hours.setMinValue(0);

    np_minutes = ( NumberPicker ) inflatedView.findViewById( R.id.minuteNumber );
    np_minutes.setMaxValue(60);
    np_minutes.setMinValue(0);


}