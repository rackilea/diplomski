public static long ab=-1;//this is flied ,don't put in the method



Button btn1 = (Button) findViewById(R.id.button2);
btn1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View arg0) {
    AlertDialog.Builder builder = new     AlertDialog.Builder(WorkDetailsTable.this);
    builder.setTitle("Data Saved");
    builder.setMessage("Are you sure you want to save?");
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int ii) {
           ab = ts.insertTimeSheet(name, weather, date, status,b,i);         

}