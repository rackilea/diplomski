public void onClick(View v) {
    // These should be class variables, like count, you don't need to re-find it on every click
    TableLayout tableLayout1 = (TableLayout) findViewById(R.id.tableLayout1);
    EditText editText1 = (EditText) findViewById(R.id.editText1);
    EditText editText2 = (EditText) findViewById(R.id.editText2);

    switch(v.getId()){
    case R.id.button1:
        if(count != 9){
            count++;

            // Create the row only when the add button is clicked
            TableRow tempRow = new TableRow(MainActivity.this);
            EditText tempText1 = new EditText(MainActivity.this);
            EditText tempText2 = new EditText(MainActivity.this);
            tempText1.setInputType(InputType.TYPE_CLASS_TEXT);
            tempText2.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);

            tempRow.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            tempText1.setLayoutParams(editText1.getLayoutParams());
            tempText2.setLayoutParams(editText2.getLayoutParams());

            tempRow.addView(tempText1);
            tempRow.addView(tempText2);
            tableLayout1.addView(tempRow);
        } else {
            // Consider using Activity's showDialog() method, to reuse this "error" dialog rather than create a new one every time
            final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create(); //Read Update
            alertDialog.setTitle("Error");
            alertDialog.setMessage("You can only have 10 rows!");

            alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });

            alertDialog.show();
        }
        break;
    case R.id.button2:
        if(count != 0){
            // Remove the last row at count or use "tableLayout1.getChildCount() - 1"
            tableLayout1.removeView(tableLayout1.getChildAt(count));
            count--;
        } else {
            // Consider reusing the other "error" Dialog and simply changing the message
            final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create(); //Read Update
            alertDialog.setTitle("Error");
            alertDialog.setMessage("You must have at least one row!");

            alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });

            alertDialog.show();
        }
        break;
    default:
        //Do something;
    }
}