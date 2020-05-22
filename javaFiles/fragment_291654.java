public void viewAll() {
    Cursor res = myDb.getAllData();
    if (res.getCount() == 0) {
        // show error
        System.out.println("No Data Found");
        return;
    }

   TextView textViewID = (TextView) findViewById(R.id.textViewID);
   textViewID.setText("");
   TextView textViewName = (TextView) findViewById(R.id.textViewName);
   textViewName.setText("");
   TextView textViewDescription = (TextView) findViewById(R.id.textViewDescription);
   textViewDescription.setText("");
   TextView textViewLocation = (TextView) findViewById(R.id.textViewLocation);
   textViewLocation.setText("");


    while (res.moveToNext()) {
        System.out.println("Id: " + res.getString(0) + "\n");
        System.out.println("Title: " + res.getString(1) + "\n");
        System.out.println("Description: " + res.getString(2) + "\n");
        System.out.println("Location: " + res.getString(4) + "\n\n");
        textViewId.setText(textViewID.getText().toString()+res.getString(0) + "\n");
        textViewName.setText(textViewName.getText().toString()+"Name: " + res.getString(1) + "\n");
        textViewDescription.setText(textViewDescription.getText().toString() + "Description: " + res.getString(2) + "\n");
        textViewLocation.setText(textViewLocation.getText().toString() + "Location: " + res.getString(4) + "\n");
    }
}