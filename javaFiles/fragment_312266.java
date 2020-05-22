@Override
public void bindView(View view, Context context, Cursor cursor) {
    // don't call this here; the cursor is already positioned on the
    // the correct record when this method is called
//  cursor.moveToFirst();

    // you need to call findViewById on the view parameter
//  TextView Accnameview = (TextView)findViewById(R.id.textView);
//  TextView Incomevalueview=(TextView)findViewById(R.id.textView2);
    TextView Accnameview = (TextView) view.findViewById(R.id.textView);
    TextView Incomevalueview=(TextView) view.findViewById(R.id.textView2);


    String accname = cursor.getString(cursor.getColumnIndex(DBOperations.COL_ACC_NAME));
    String incomev =cursor.getString(cursor.getColumnIndex(DBOperations.COL_DEBIT));


    Accnameview.setText(accname);
    Incomevalueview.setText(incomev);

}